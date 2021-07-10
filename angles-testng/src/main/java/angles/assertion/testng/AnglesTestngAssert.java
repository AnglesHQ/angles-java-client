package angles.assertion.testng;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import static angles.assertion.AssertHelper.anglesAssertGreaterThan;
import static angles.assertion.AssertHelper.anglesAssertLessThan;
import static angles.util.AnglesReporterUtils.getAnglesReporter;

public class AnglesTestngAssert extends Assertion {

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        getAnglesReporter().pass("Assert", assertCommand.getExpected().toString(),
                assertCommand.getActual().toString(), assertCommand.getMessage());
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        getAnglesReporter().fail("Assert", assertCommand.getExpected().toString(),
                assertCommand.getActual().toString(), assertCommand.getMessage());
    }

    public void assertGreaterThan(Double value1, Double value2) {
        assertEquals(anglesAssertGreaterThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is Greater than [" + value2.toString() + "]");
    }

    public void assertLessThan(Double value1, Double value2) {
        assertEquals(anglesAssertLessThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is less than [" + value2.toString() + "]");
    }

    public void assertGreaterThan(Integer value1, Integer value2) {
        assertEquals(anglesAssertGreaterThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is Greater than [" + value2.toString() + "]");
    }

    public void assertLessThan(Integer value1, Integer value2) {
        assertEquals(anglesAssertLessThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is less than [" + value2.toString() + "]");
    }

    public void assertGreaterThan(Float value1, Float value2) {
        assertEquals(anglesAssertGreaterThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is Greater than [" + value2.toString() + "]");
    }

    public void assertLessThan(Float value1, Float value2) {
        assertEquals(anglesAssertLessThan(value1, value2, false), true,
                "Checking if [" + value1.toString() + "] is less than [" + value2.toString() + "]");
    }

    public void assertGreaterThan(String value1, String value2) {
        assertEquals(anglesAssertGreaterThan(value1, value2, false), true,
                "Checking if [" + value1 + "] is Greater than [" + value2 + "]");
    }

    public void assertLessThan(String value1, String value2) {
        assertEquals(anglesAssertLessThan(value1, value2, false), true,
                "Checking if [" + value1 + "] is less than [" + value2 + "]");
    }
}