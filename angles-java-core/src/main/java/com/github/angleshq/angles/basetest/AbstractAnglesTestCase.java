package com.github.angleshq.angles.basetest;

import com.github.angleshq.angles.AnglesReporterInterface;
import com.github.angleshq.angles.exceptions.AnglesPropertyNotGivenException;

import static com.github.angleshq.angles.util.AnglesReporterUtils.*;

public abstract class AbstractAnglesTestCase {

    protected AnglesReporterInterface anglesReporter;

    protected AbstractAnglesTestCase() {
        try {
            anglesReporter = initialiseAnglesTestParameters();
            anglesReporter.startBuild(getRunName(), getEnvironment(), getTeam(), getComponent(), getPhase());
        } catch (AnglesPropertyNotGivenException e) {
            System.out.println("Please ensure you provide all required system properties for Angles Dashboard.");
        }
    }
}
