package angles.assertion.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.util.StringUtils;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static angles.assertion.AssertHelper.*;
import static angles.assertion.junit.AssertHelperJUnit5.handleDoesNotThrow;
import static angles.assertion.junit.AssertHelperJUnit5.handleThrows;


public class AnglesJUnit5Assert {

    public void assertTrue(boolean condition) {
        handleAssertEquals("AssertTrue", true, condition);
        Assertions.assertTrue(condition);
    }

    public void assertTrue(boolean condition, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertTrue", true, condition,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertTrue(condition, messageSupplier);
    }

    public void assertTrue(BooleanSupplier booleanSupplier) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean());
        Assertions.assertTrue(booleanSupplier);
    }

    public void assertTrue(BooleanSupplier booleanSupplier, String message) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean(), message);
        Assertions.assertTrue(booleanSupplier, message);
    }

    public void assertTrue(boolean condition, String message) {
        handleAssertEquals("AssertTrue", true, condition, message);
        Assertions.assertTrue(condition, message);
    }

    public void assertTrue(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean(),
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertTrue(booleanSupplier, messageSupplier);
    }

    public void assertFalse(boolean condition) {
        handleAssertEquals("AssertFalse", false, condition);
        Assertions.assertFalse(condition);
    }

    public void assertFalse(boolean condition, String message) {
        handleAssertEquals("AssertFalse", false, condition, message);
        Assertions.assertFalse(condition, message);
    }

    public void assertFalse(boolean condition, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertFalse", false, condition,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertFalse(condition, messageSupplier);
    }

    public void assertFalse(BooleanSupplier booleanSupplier) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean());
        Assertions.assertFalse(booleanSupplier);
    }

    public void assertFalse(BooleanSupplier booleanSupplier, String message) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean(), message);
        Assertions.assertFalse(booleanSupplier, message);
    }

    public void assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean(),
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertFalse(booleanSupplier, messageSupplier);
    }

    public void assertNull(Object actual) {
        handleAssertNull("AssertNull", actual);
        Assertions.assertNull(actual);
    }

    public void assertNull(Object actual, String message) {
        handleAssertEquals("AssertNull", null, actual, message);
        Assertions.assertNull(actual, message);
    }

    public void assertNull(Object actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertNull", null, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNull(actual, messageSupplier);
    }

    public void assertNotNull(Object actual) {
        handleAssertNotNull("AssertNotNull", actual);
        Assertions.assertNotNull(actual);
    }

    public void assertNotNull(Object actual, String message) {
        handleAssertNotEquals("AssertNotNull", null, actual, message);
        Assertions.assertNotNull(actual, message);
    }

    public void assertNotNull(Object actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotNull", null, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotNull(actual, messageSupplier);
    }

    public void assertEquals(String expected, String actual) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(String expected, String actual, String message) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(String expected, String actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(boolean expected, boolean actual) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(boolean expected, Boolean actual) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Boolean expected, short actual) {
        handleAssertEquals("AssertEquals (Boolean/short)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Boolean expected, Boolean actual) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(boolean expected, boolean actual, String message) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(boolean expected, Boolean actual, String message) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Boolean expected, boolean actual, String message) {
        handleAssertEquals("AssertEquals (Boolean/boolean)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Boolean expected, Boolean actual, String message) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(boolean expected, boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(boolean expected, Boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Boolean expected, boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Boolean/boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Boolean expected, Boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(short expected, short actual) {
        handleAssertEquals("AssertEquals (short/short)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(short expected, Short actual) {
        handleAssertEquals("AssertEquals (short/Short)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Short expected, short actual) {
        handleAssertEquals("AssertEquals (Short/short)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Short expected, Short actual) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(short expected, short actual, String message) {
        handleAssertEquals("AssertEquals (short/short)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(short expected, Short actual, String message) {
        handleAssertEquals("AssertEquals (short/Short)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Short expected, short actual, String message) {
        handleAssertEquals("AssertEquals (Short/short)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Short expected, Short actual, String message) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(short expected, short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (short/short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(short expected, Short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (short/Short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Short expected, short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Short/short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Short expected, Short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(byte expected, byte actual) {
        handleAssertEquals("AssertEquals (byte/byte)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(byte expected, Byte actual) {
        handleAssertEquals("AssertEquals (byte/Byte)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Byte expected, byte actual) {
        handleAssertEquals("AssertEquals (Byte/byte)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Byte expected, Byte actual) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(byte expected, byte actual, String message) {
        handleAssertEquals("AssertEquals (byte/byte)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(byte expected, Byte actual, String message) {
        handleAssertEquals("AssertEquals (byte/Byte)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Byte expected, byte actual, String message) {
        handleAssertEquals("AssertEquals (Byte/byte)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }


    public void assertEquals(Byte expected, Byte actual, String message) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(byte expected, byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (byte/byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(byte expected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (byte/Byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Byte expected, byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Byte/byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Byte expected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(int expected, int actual) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(int expected, Integer actual) {
        handleAssertEquals("AssertEquals (int/Integer)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Integer expected, int actual) {
        handleAssertEquals("AssertEquals (Integer/int)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }


    public void assertEquals(Integer expected, Integer actual) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(int expected, int actual, String message) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(int expected, Integer actual, String message) {
        handleAssertEquals("AssertEquals (int/Integer)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Integer expected, int actual, String message) {
        handleAssertEquals("AssertEquals (Integer/int)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Integer expected, Integer actual, String message) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(int expected, int actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(int expected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (int/Integer)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Integer expected, int actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Integer/int)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Integer expected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(long expected, long actual) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(long expected, Long actual) {
        handleAssertEquals("AssertEquals (long/Long)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Long expected, long actual) {
        handleAssertEquals("AssertEquals (Long/long)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Long expected, Long actual) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(long expected, long actual, String message) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(long expected, Long actual, String message) {
        handleAssertEquals("AssertEquals (long/Long)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Long expected, long actual, String message) {
        handleAssertEquals("AssertEquals (Long/long)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Long expected, Long actual, String message) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(long expected, long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(long expected, Long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (long/Long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Long expected, long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Long/long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Long expected, Long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(float expected, float actual) {
        handleAssertEquals("AssertEquals (float/float)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(float expected, Float actual) {
        handleAssertEquals("AssertEquals (float/Float)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Float expected, float actual) {
        handleAssertEquals("AssertEquals (Float/float)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Float expected, Float actual) {
        handleAssertEquals("AssertEquals (Float/Float)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(float expected, float actual, String message) {
        handleAssertEquals("AssertEquals (float/float)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(float expected, Float actual, String message) {
        handleAssertEquals("AssertEquals (float/Float)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Float expected, float actual, String message) {
        handleAssertEquals("AssertEquals (Float/float)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Float expected, Float actual, String message) {
        handleAssertEquals("AssertEquals (Float/Float)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(float expected, float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (float/float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(float expected, Float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (float/Float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Float expected, float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Float/float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Float expected, Float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Float/Float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(double expected, double actual) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(double expected, Double actual) {
        handleAssertEquals("AssertEquals (double/Double)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Double expected, double actual) {
        handleAssertEquals("AssertEquals (Double/double)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Double expected, Double actual) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(double expected, double actual, String message) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(double expected, Double actual, String message) {
        handleAssertEquals("AssertEquals (double/Double)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Double expected, double actual, String message) {
        handleAssertEquals("AssertEquals (Double/double)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Double expected, Double actual, String message) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(double expected, double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(double expected, Double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (double/Double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Double expected, double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Double/double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Double expected, Double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(char expected, char actual) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(char expected, Character actual) {
        handleAssertEquals("AssertEquals (char/Character)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Character expected, char actual) {
        handleAssertEquals("AssertEquals (Character/char)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Character expected, Character actual) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(char expected, char actual, String message) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(char expected, Character actual, String message) {
        handleAssertEquals("AssertEquals (char/Character)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Character expected, char actual, String message) {
        handleAssertEquals("AssertEquals (Character/char)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Character expected, Character actual, String message) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(char expected, char actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(char expected, Character actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (char/Character)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Character expected, char actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Character/char)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Character expected, Character actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertEquals(Object expected, Object actual) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    public void assertEquals(Object expected, Object actual, String message) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual, message);
        Assertions.assertEquals(expected, actual, message);
    }

    public void assertEquals(Object expected, Object actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual, String message) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(char[] expected, char[] actual) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(char[] expected, char[] actual, String message) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(char[] expected, char[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual, String message) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(short[] expected, short[] actual) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(short[] expected, short[] actual, String message) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(short[] expected, short[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(int[] expected, int[] actual) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(int[] expected, int[] actual, String message) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(int[] expected, int[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(long[] expected, long[] actual) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(long[] expected, long[] actual, String message) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(long[] expected, long[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(float[] expected, float[] actual) {
        handleAssertEquals("AssertEquals (float[]/float[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(float[] expected, float[] actual, String message) {
        handleAssertEquals("AssertEquals (float[]/float[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(float[] expected, float[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (float[]/float[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(double[] expected, double[] actual) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(double[] expected, double[] actual, String message) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(double[] expected, double[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual, String message) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual, message);
        Assertions.assertArrayEquals(expected, actual, message);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertArrayEquals(expected, actual, messageSupplier);
    }

    public void assertNotEquals(byte unexpected, byte actual) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(byte unexpected, Byte actual) {
        handleAssertNotEquals("AssertNotEquals (byte/Byte)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Byte unexpected, byte actual) {
        handleAssertNotEquals("AssertNotEquals (Byte/byte)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Byte unexpected, Byte actual) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(byte unexpected, byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(byte unexpected, Byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (byte/Byte)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Byte unexpected, byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Byte/byte)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Byte unexpected, Byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(byte unexpected, byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(byte unexpected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (byte/Byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Byte unexpected, byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Byte/byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Byte unexpected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(short unexpected, short actual) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(short unexpected, Short actual) {
        handleAssertNotEquals("AssertNotEquals (short/Short)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Short unexpected, short actual) {
        handleAssertNotEquals("AssertNotEquals (Short/short)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Short unexpected, Short actual) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(short unexpected, short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(short unexpected, Short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (short/Short)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Short unexpected, short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Short/short)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Short unexpected, Short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(short unexpected, short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(short unexpected, Short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (short/Short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Short unexpected, short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Short/short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Short unexpected, Short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(int unexpected, int actual) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(int unexpected, Integer actual) {
        handleAssertNotEquals("AssertNotEquals (int/Integer)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Integer unexpected, int actual) {
        handleAssertNotEquals("AssertNotEquals (Integer/int)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Integer unexpected, Integer actual) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(int unexpected, int actual, String message) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(int unexpected, Integer actual, String message) {
        handleAssertNotEquals("AssertNotEquals (int/Integer)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Integer unexpected, int actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Integer/int)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Integer unexpected, Integer actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(int unexpected, int actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(int unexpected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (int/Integer)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Integer unexpected, int actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Integer/int)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Integer unexpected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(long unexpected, long actual) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(long unexpected, Long actual) {
        handleAssertNotEquals("AssertNotEquals (long/Long)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Long unexpected, long actual) {
        handleAssertNotEquals("AssertNotEquals (Long/long)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Long unexpected, Long actual) {
        handleAssertNotEquals("AssertNotEquals (Long/Long)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(long unexpected, long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(long unexpected, Long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (long/Long)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Long unexpected, long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Long/long)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Long unexpected, Long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Long/Long)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(long unexpected, long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(long unexpected, Long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (long/Long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Long unexpected, long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Long/long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Long unexpected, Long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Long/Long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(float unexpected, float actual) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(float unexpected, Float actual) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, float actual) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, Float actual) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(float unexpected, float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(float unexpected, Float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Float unexpected, float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Float unexpected, Float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(float unexpected, float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(float unexpected, Float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Float unexpected, float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Float unexpected, Float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(double unexpected, double actual) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(double unexpected, Double actual) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, double actual) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, Double actual) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(double unexpected, double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(double unexpected, Double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Double unexpected, double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Double unexpected, Double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(double unexpected, double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(double unexpected, Double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Double unexpected, double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Double unexpected, Double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(char unexpected, char actual) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(char unexpected, Character actual) {
        handleAssertNotEquals("AssertNotEquals (char/Character)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Character unexpected, char actual) {
        handleAssertNotEquals("AssertNotEquals (Character/char)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Character unexpected, Character actual) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(char unexpected, char actual, String message) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(char unexpected, Character actual, String message) {
        handleAssertNotEquals("AssertNotEquals (char/Character)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Character unexpected, char actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Character/char)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Character unexpected, Character actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(char unexpected, char actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(char unexpected, Character actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (char/Character)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Character unexpected, char actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Character/char)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Character unexpected, Character actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertNotEquals(Object unexpected, Object actual) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual);
        Assertions.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Object unexpected, Object actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual, message);
        Assertions.assertNotEquals(unexpected, actual, message);
    }

    public void assertNotEquals(Object unexpected, Object actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotEquals(unexpected, actual, messageSupplier);
    }

    public void assertSame(Object expected, Object actual) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual);
        Assertions.assertSame(expected, actual);
    }

    public void assertSame(Object expected, Object actual, String message) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual, message);
        Assertions.assertSame(expected, actual, message);
    }

    public void assertSame(Object expected, Object actual, Supplier<String> messageSupplier) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertSame(expected, actual, messageSupplier);
    }

    public void assertNotSame(Object unexpected, Object actual) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual);
        Assertions.assertNotSame(unexpected, actual);
    }

    public void assertNotSame(Object unexpected, Object actual, String message) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual, message);
        Assertions.assertNotSame(unexpected, actual, message);
    }

    public void assertNotSame(Object unexpected, Object actual, Supplier<String> messageSupplier) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertNotSame(unexpected, actual, messageSupplier);
    }

    public void assertDoesNotThrow(Executable executable) {
        handleDoesNotThrow("AssertDoesNotThrow", executable);
        Assertions.assertDoesNotThrow(executable);
    }

    public void assertDoesNotThrow(Executable executable, String message) {
        handleDoesNotThrow("AssertDoesNotThrow", executable, message);
        Assertions.assertDoesNotThrow(executable, message);
    }

    public void assertDoesNotThrow(Executable executable, Supplier<String> messageSupplier) {
        handleDoesNotThrow("AssertDoesNotThrow", executable, buildPrefix(nullSafeGet(messageSupplier)));
        Assertions.assertDoesNotThrow(executable, messageSupplier);
    }

    public void assertThrowsException(Class expected, Executable executable, String... info) {
        String message = info.length > 0 ? info[0] : "";
        handleThrows("AssertThrows " + expected.toString(), expected, executable, message);
        Assertions.assertThrows(expected, executable);
    }

    public void assertGreaterThan(Double value1, Double value2) {
        Assertions.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Double value1, Double value2) {
        Assertions.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(Integer value1, Integer value2) {
        Assertions.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Integer value1, Integer value2) {
        Assertions.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(Float value1, Float value2) {
        Assertions.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Float value1, Float value2) {
        Assertions.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(String value1, String value2) {
        Assertions.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(String value1, String value2) {
        Assertions.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    private String buildPrefix(String message) {
        return StringUtils.isNotBlank(message) ? message + " ==> " : "";
    }

    private String nullSafeGet(Supplier<String> messageSupplier) {
        return messageSupplier != null ? (String) messageSupplier.get() : null;
    }

    /*
        TODO:
        Implement these remaining methods from JUnit's Assertion class:
        public void assertEquals(float expected, float actual, float delta)
        public void assertEquals(double expected, double actual, double delta)
        public void assertEquals(float expected, float actual, float delta, Supplier<String> messageSupplier)
        public void assertEquals(float expected, float actual, float delta, String message)
        public void assertEquals(double expected, double actual, double delta, String message)
        public void assertEquals(double expected, double actual, double delta, Supplier<String> messageSupplier)
        public void assertNotEquals(float unexpected, float actual, float delta)
        public void assertNotEquals(float unexpected, float actual, float delta, String message)
        public void assertNotEquals(float unexpected, float actual, float delta, Supplier<String> messageSupplier)
        public void assertNotEquals(double unexpected, double actual, double delta)
        public void assertNotEquals(double unexpected, double actual, double delta, String message)
        public void assertNotEquals(double unexpected, double actual, double delta, Supplier<String> messageSupplier)
        public void assertAll(Executable... executables) throws MultipleFailuresError
        public void assertAll(String heading, Executable... executables) throws MultipleFailuresError
        public void assertAll(Collection<Executable> executables) throws MultipleFailuresError
        public void assertAll(String heading, Collection<Executable> executables) throws MultipleFailuresError
        public void assertAll(Stream<Executable> executables) throws MultipleFailuresError
        public void assertAll(String heading, Stream<Executable> executables) throws MultipleFailuresError
        public void assertTimeout(Duration timeout, Executable executable)
        public void assertTimeout(Duration timeout, Executable executable, String message)
        public void assertTimeout(Duration timeout, Executable executable, Supplier<String> messageSupplier)
        public void assertTimeoutPreemptively(Duration timeout, Executable executable)
        public void assertTimeoutPreemptively(Duration timeout, Executable executable, String message)
        public void assertTimeoutPreemptively(Duration timeout, Executable executable, Supplier<String> messageSupplier)
        public void assertIterableEquals(Iterable<?> expected, Iterable<?> actual)
        public void assertIterableEquals(Iterable<?> expected, Iterable<?> actual, String message)
        public void assertIterableEquals(Iterable<?> expected, Iterable<?> actual, Supplier<String> messageSupplier)
        public void assertLinesMatch(List<String> expectedLines, List<String> actualLines)
        public void assertLinesMatch(List<String> expectedLines, List<String> actualLines, String message)
        public void assertLinesMatch(List<String> expectedLines, List<String> actualLines, Supplier<String> messageSupplier)
        public void assertLinesMatch(Stream<String> expectedLines, Stream<String> actualLines)
        public void assertLinesMatch(Stream<String> expectedLines, Stream<String> actualLines, String message)
        public void assertLinesMatch(Stream<String> expectedLines, Stream<String> actualLines, Supplier<String> messageSupplier)
        public void assertArrayEquals(double[] expected, double[] actual, double delta)
        public void assertArrayEquals(double[] expected, double[] actual, double delta, String message)
        public void assertArrayEquals(double[] expected, double[] actual, double delta, Supplier<String> messageSupplier)
        public void assertArrayEquals(float[] expected, float[] actual, float delta)
        public void assertArrayEquals(float[] expected, float[] actual, float delta, String message)
        public void assertArrayEquals(float[] expected, float[] actual, float delta, Supplier<String> messageSupplier)
     */
}
