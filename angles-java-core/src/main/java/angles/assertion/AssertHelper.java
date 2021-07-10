package angles.assertion;

//import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.Objects;

import static angles.util.AnglesReporterUtils.getAnglesReporter;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class AssertHelper {

    public static boolean anglesAssertGreaterThan(Double value1, Double value2) {
        return anglesAssertGreaterThan(value1, value2, true);
    }

    public static boolean anglesAssertGreaterThan(Double value1, Double value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == 1;
        if (doAssert) {
            handleAssertEquals("AssertGreaterThan (Double)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is greater than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertLessThan(Double value1, Double value2) {
        return anglesAssertLessThan(value1, value2, true);
    }

    public static boolean anglesAssertLessThan(Double value1, Double value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == -1;
        if (doAssert) {
            handleAssertEquals("AssertLessThan (Double)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is less than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertGreaterThan(Integer value1, Integer value2) {
        return anglesAssertGreaterThan(value1, value2, true);
    }

    public static boolean anglesAssertGreaterThan(Integer value1, Integer value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == 1;
        if (doAssert) {
            handleAssertEquals("AssertGreaterThan (Integer)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is greater than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertLessThan(Integer value1, Integer value2) {
        return anglesAssertLessThan(value1, value2, true);
    }

    public static boolean anglesAssertLessThan(Integer value1, Integer value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == -1;
        if (doAssert) {
            handleAssertEquals("AssertLessThan (Integer)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is less than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertGreaterThan(Float value1, Float value2) {
        return anglesAssertGreaterThan(value1, value2, true);
    }

    public static boolean anglesAssertGreaterThan(Float value1, Float value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == 1;
        if (doAssert) {
            handleAssertEquals("AssertGreaterThan (Float)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is greater than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertLessThan(Float value1, Float value2) {
        return anglesAssertLessThan(value1, value2, true);
    }

    public static boolean anglesAssertLessThan(Float value1, Float value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1.toString());
        BigDecimal b = new BigDecimal(value2.toString());
        boolean comparison = a.compareTo(b) == -1;
        if (doAssert) {
            handleAssertEquals("AssertLessThan (Float)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is less than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertGreaterThan(String value1, String value2) {
        return anglesAssertGreaterThan(value1, value2, true);
    }

    public static boolean anglesAssertGreaterThan(String value1, String value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);
        boolean comparison = a.compareTo(b) == 1;
        if (doAssert) {
            handleAssertEquals("AssertGreaterThan (String)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is greater than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static boolean anglesAssertLessThan(String value1, String value2) {
        return anglesAssertLessThan(value1, value2, true);
    }

    public static boolean anglesAssertLessThan(String value1, String value2, boolean doAssert) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);
        boolean comparison = a.compareTo(b) == -1;
        if (doAssert) {
            handleAssertEquals("AssertLessThan (String)", true, comparison,
                    "Checking if [" + a.toPlainString() + "] is less than [" + b.toPlainString() + "]");
        }
        return comparison;
    }

    public static void handleAssertSame(String step, Object expected, Object actual) {
        handleAssertSame(step, expected, actual, EMPTY);
    }

    public static void handleAssertSame(String step, Object expected, Object actual, String details) {
        if (expected == actual) {
            getAnglesReporter().pass(step, expected.toString(), actual.toString(), details);
        } else {
            getAnglesReporter().fail(step, expected.toString(), actual.toString(), details);
        }
    }

    public static void handleAssertNotSame(String step, Object expected, Object actual) {
        handleAssertEquals(step, expected, actual, EMPTY);
    }

    public static void handleAssertNotSame(String step, Object expected, Object actual, String details) {
        if (expected != actual) {
            getAnglesReporter().pass(step, expected.toString(), actual.toString(), details);
        } else {
            getAnglesReporter().fail(step, expected.toString(), actual.toString(), details);
        }
    }

    public static void handleAssertEquals(String step, Object expected, Object actual) {
        handleAssertEquals(step, expected, actual, EMPTY);
    }

    public static void handleAssertNull(String step, Object actual) {
        if (Objects.isNull(actual)) {
            getAnglesReporter().pass(step, "null", "null", EMPTY);
        } else {
            getAnglesReporter().fail(step, "null", "null", EMPTY);
        }
    }

    public static void handleAssertNotNull(String step, Object actual) {
        if (!Objects.isNull(actual)) {
            getAnglesReporter().pass(step, "null", actual.toString(), EMPTY);
        } else {
            getAnglesReporter().fail(step, "null", actual.toString(), EMPTY);
        }
    }

    public static void handleAssertEquals(String step, Object expected, Object actual, String details) {
        if(Objects.isNull(expected)){
            expected = new String("null");
        }
        if(Objects.isNull(actual)){
            actual = new String("null");
        }
        if (expected.equals(actual)) {
            getAnglesReporter().pass(step, expected.toString(), actual.toString(), details);
        } else {
            getAnglesReporter().fail(step, expected.toString(), actual.toString(), details);
        }
    }

    public static void handleAssertNotEquals(String step, Object expected, Object actual) {
        handleAssertNotEquals(step, expected, actual, EMPTY);
    }

    public static void handleAssertNotEquals(String step, Object expected, Object actual, String details) {
        if (!expected.equals(actual)) {
            getAnglesReporter().pass(step, expected.toString(), actual.toString(), details);
        } else {
            getAnglesReporter().fail(step, expected.toString(), actual.toString(), details);
        }
    }

}
