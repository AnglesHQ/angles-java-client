package com.github.angleshq.angles.listeners.cucumber;

import com.github.angleshq.angles.assertion.cucumber.AnglesJUnitAssert;
import com.github.angleshq.angles.basetest.AbstractAnglesTestCase;
import cucumber.api.Result;
import cucumber.api.TestStep;
import cucumber.api.event.*;
import cucumber.api.formatter.Formatter;
import cucumber.runner.PickleTestStep;
import gherkin.pickles.PickleCell;
import gherkin.pickles.PickleRow;
import gherkin.pickles.PickleTable;

public class AnglesCucumber2Adapter extends AbstractAnglesTestCase implements Formatter {
    //initialize the assertion instance
    protected AnglesJUnitAssert doAssert = new AnglesJUnitAssert();

    //event handlers - Angles loggers
    protected EventHandler<TestStepStarted> handleTestStepFinished = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted event) {
            TestStep testStep = event.testStep;
            if (testStep.getClass() == PickleTestStep.class) {
                String text = event.testStep.getStepText();
                anglesReporter.startAction(text);
                anglesReporter.info(text);
                String argumentTable = "\n";
                try {
                    PickleTable argument = (PickleTable) testStep.getStepArgument().get(0);
                    for (PickleRow row : argument.getRows()) {
                        argumentTable += "\n| ";
                        for (PickleCell cell : row.getCells()) {
                            argumentTable += cell.getValue() + " | ";
                        }
                    }
                    anglesReporter.info(argumentTable);
                } catch (Exception e) {
                    anglesReporter.info("Cannot show argument table: " + e.getMessage());
                }
            } else {
                String hookName = testStep.getHookType().name();
                if (hookName.equals("Before")) {
                    anglesReporter.startAction("Setup");
                    anglesReporter.info(hookName);
                } else if (hookName.equals("After")) {
                    anglesReporter.startAction("Cleanup");
                    anglesReporter.info(hookName);
                }
            }
        }
    };

    protected EventHandler<TestCaseStarted> handleTestCaseStarted = new EventHandler<TestCaseStarted>() {
        @Override
        public void receive(TestCaseStarted event) {
            String[] featurePath = event.testCase.getScenarioDesignation().split(":");
            String featureName = featurePath[0];
            //further split the path to get just the feature file name itself
            featurePath = featureName.split("/");
            featureName = featurePath[featurePath.length - 1];
            String testName = event.testCase.getName();
            anglesReporter.startTest(featureName, testName);
        }
    };

    protected EventHandler<TestCaseFinished> handleTestCaseFinished = new EventHandler<TestCaseFinished>() {
        @Override
        public void receive(TestCaseFinished event) {
            cucumber.api.TestCase testCase = event.testCase;
            Result result = event.result;
            Throwable error = result.getError();
            String scenarioName = testCase.getName();
            TestStep testStep = testCase.getTestSteps().get(0);
            String text = testStep.getHookType().toString();
            String id = "" + testCase.getUri() + testCase.getLine();
            System.out.println("Testcase " + id + " - " + result.getStatus());
            if (result.getStatus().equals(Result.Type.PASSED)) {
                anglesReporter.pass(scenarioName + " passed!", "", "", "");
            }
            if (result.getStatus().equals(Result.Type.FAILED)) {
                anglesReporter.fail(scenarioName + " failed!", "",
                        event.result.getErrorMessage(), "Test has failed");
            }
            if (result.getStatus().equals(Result.Type.SKIPPED)) {
                anglesReporter.fail(scenarioName + " skipped!", "", "", "Test NOT RUN");
            }
            anglesReporter.saveTest();
        }
    };

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, handleTestCaseFinished);
        publisher.registerHandlerFor(TestCaseStarted.class, handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepStarted.class, handleTestStepFinished);
    }
}

