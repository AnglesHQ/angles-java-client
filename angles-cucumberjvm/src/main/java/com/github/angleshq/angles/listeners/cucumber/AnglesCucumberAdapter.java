package com.github.angleshq.angles.listeners.cucumber;

import com.github.angleshq.angles.assertion.cucumber.AnglesJUnitAssert;
import com.github.angleshq.angles.basetest.AbstractAnglesTestCase;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.util.List;

public class AnglesCucumberAdapter extends AbstractAnglesTestCase implements ConcurrentEventListener {
    //initialize the assertion instance
    protected AnglesJUnitAssert doAssert = new AnglesJUnitAssert();

    //event handlers - Angles loggers
    protected EventHandler<TestStepStarted> handleTestStepFinished = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted event) {
            TestStep testStep = event.getTestStep();
            if (testStep.getClass().getName().equals("io.cucumber.core.runner.PickleStepTestStep")) {
                PickleStepTestStep pickleStepTestStep = (PickleStepTestStep) testStep;
                anglesReporter.startAction(pickleStepTestStep.getStep().getKeyword() + pickleStepTestStep.getStep().getText());
                anglesReporter.info("Starting step: " + pickleStepTestStep.getStep().getText());
                String argumentTable = "";
                try {
                    DataTableArgument argument = (DataTableArgument) pickleStepTestStep.getStep().getArgument();
                    if (argument != null) {
                        List<List<String>> cells = argument.cells();
                        for (List<String> row : argument.cells()) {
                            argumentTable += "DataTable: \n| ";
                            for (String value : row) {
                                argumentTable += value + " | ";
                            }
                        }
                        anglesReporter.info(argumentTable);
                    }
                } catch (Exception e) {
                    anglesReporter.info("Cannot show argument table: " + e.getMessage());
                }
            } else {
                String hookName = testStep.toString();
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
            String[] featurePath = event.getTestCase().getScenarioDesignation().split(":");
            String featureName = featurePath[0];
            //further split the path to get just the feature file name itself
            featurePath = featureName.split("/");
            featureName = featurePath[featurePath.length - 1];
            String testName = event.getTestCase().getName();
            anglesReporter.startTest(featureName, testName);
        }
    };

    protected EventHandler<TestCaseFinished> handleTestCaseFinished = new EventHandler<TestCaseFinished>() {
        @Override
        public void receive(TestCaseFinished event) {
            TestCase testCase = event.getTestCase();
            Result result = event.getResult();
            String scenarioName = testCase.getName();
            if (result.getStatus().equals(Status.PASSED)) {
                anglesReporter.pass(scenarioName + " passed!", "", "", "");
            }
            if (result.getStatus().equals(Status.FAILED)) {
                // errors and failures seem to be handled the same way.
                anglesReporter.fail(scenarioName + " failed!", "",
                        event.getResult().getError().getMessage(), "Test has failed");
            }
            if (result.getStatus().equals(Status.SKIPPED)) {
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

