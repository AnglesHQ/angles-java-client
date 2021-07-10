package angles.basetest.testng;

import angles.assertion.testng.AnglesTestngAssert;
import angles.basetest.AbstractAnglesTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AnglesTestngBaseTest extends AbstractAnglesTestCase {

    protected AnglesTestngAssert doAssert = new AnglesTestngAssert();

    /**
     * Starts a test run within Angles. Override to customise test name.
     * @param method
     */
    @BeforeMethod(alwaysRun = true)
    public void anglesBeforeMethod(Method method) {
        String suiteName = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();
        anglesReporter.startTest(suiteName, methodName);
    }

    @AfterMethod(alwaysRun = true)
    public void anglesAfterMethod(Method method) {
        anglesReporter.saveTest();
    }
}