package angles.basetest;

import angles.AnglesReporterInterface;
import angles.exceptions.AnglesPropertyNotGivenException;

import static angles.util.AnglesReporterUtils.*;

public abstract class AbstractAnglesTestCase {

    protected AnglesReporterInterface anglesReporter;

    protected AbstractAnglesTestCase() {
        try {
            anglesReporter = initialiseAnglesTestParameters();
            anglesReporter.startBuild(getRunName(), getEnvironment(), getTeam(), getComponent());
        } catch (AnglesPropertyNotGivenException e) {
            System.out.println("Please ensure you provide all required system properties for Angles Dashboard.");
        }
    }
}