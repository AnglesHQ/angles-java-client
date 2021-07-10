package angles.assertion.junit;

import angles.assertion.AssertHelper;
import org.junit.jupiter.api.function.Executable;

import static angles.util.AnglesReporterUtils.getAnglesReporter;

public class AssertHelperJUnit5 extends AssertHelper {

    public static final String EMPTY = "";

    public static void handleDoesNotThrow(String step, Executable executable) {
        handleDoesNotThrow(step, executable, EMPTY);
    }

    public static void handleDoesNotThrow(String step, Executable executable, String details) {
        try {
            executable.execute();
            getAnglesReporter().pass(step, "No Exception thrown", "No Exception thrown", details);
        } catch (Throwable e) {
            getAnglesReporter().fail(step, "No Exception thrown",
                    e.getClass().getSimpleName() + " : " + e.getMessage(), details);
        }
    }

    public static void handleThrows(String step, Class expected, Executable executable, String details) {
        try {
            executable.execute();
            getAnglesReporter().fail(step, "Exception thrown", "No Exception thrown", details);
        } catch (Throwable e) {
            String actualException = e.getClass().getSimpleName();
            if (e.getClass().equals(expected)) {
                getAnglesReporter().pass(step, actualException + "Exception Thrown",
                        actualException + " : " + e.getMessage(), details);
            } else {
                getAnglesReporter().fail(step, "Incorrect exception thrown " +
                                "Expected: " + expected.getSimpleName() + " Actual:" + actualException,
                        actualException + " : " + e.getMessage(), details);
            }
        }
    }
}
