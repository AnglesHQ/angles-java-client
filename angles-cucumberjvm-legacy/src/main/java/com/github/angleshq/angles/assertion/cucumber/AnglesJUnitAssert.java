package com.github.angleshq.angles.assertion.cucumber;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;


import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.github.angleshq.angles.assertion.AssertHelper.*;


public class AnglesJUnitAssert {

    public void assertTrue(boolean condition) {
        handleAssertEquals("AssertTrue", true, condition);
        Assert.assertTrue(condition);
    }

    public void assertTrue(boolean condition, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertTrue", true, condition,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertTrue(messageSupplier.get(), condition);
    }

    public void assertTrue(BooleanSupplier booleanSupplier) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean());
        Assert.assertTrue(booleanSupplier.getAsBoolean());
    }

    public void assertTrue(BooleanSupplier booleanSupplier, String message) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean(), message);
        Assert.assertTrue(message, booleanSupplier.getAsBoolean());
    }

    public void assertTrue(boolean condition, String message) {
        handleAssertEquals("AssertTrue", true, condition, message);
        Assert.assertTrue(message, condition);
    }

    public void assertTrue(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertTrue", true, booleanSupplier.getAsBoolean(),
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertTrue(messageSupplier.get(), booleanSupplier.getAsBoolean());
    }

    public void assertFalse(boolean condition) {
        handleAssertEquals("AssertFalse", false, condition);
        Assert.assertFalse(condition);
    }

    public void assertFalse(boolean condition, String message) {
        handleAssertEquals("AssertFalse", false, condition, message);
        Assert.assertFalse(message, condition);
    }

    public void assertFalse(boolean condition, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertFalse", false, condition,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertFalse(messageSupplier.get(), condition);
    }

    public void assertFalse(BooleanSupplier booleanSupplier) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean());
        Assert.assertFalse(booleanSupplier.getAsBoolean());
    }

    public void assertFalse(BooleanSupplier booleanSupplier, String message) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean(), message);
        Assert.assertFalse(message, booleanSupplier.getAsBoolean());
    }

    public void assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertFalse", false, booleanSupplier.getAsBoolean(),
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertFalse(messageSupplier.get(), booleanSupplier.getAsBoolean());
    }

    public void assertNull(Object actual) {
        handleAssertNull("AssertNull", actual);
        Assert.assertNull(actual);
    }

    public void assertNull(Object actual, String message) {
        handleAssertEquals("AssertNull", null, actual, message);
        Assert.assertNull(message, actual);
    }

    public void assertNull(Object actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertNull", null, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNull(messageSupplier.get(), actual);
    }

    public void assertNotNull(Object actual) {
        handleAssertNotNull("AssertNotNull", actual);
        Assert.assertNotNull(actual);
    }

    public void assertNotNull(Object actual, String message) {
        handleAssertNotEquals("AssertNotNull", null, actual, message);
        Assert.assertNotNull(message, actual);
    }

    public void assertNotNull(Object actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotNull", null, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotNull(messageSupplier.get(), actual);
    }

    public void assertEquals(String expected, String actual) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(String expected, String actual, String message) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(String expected, String actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (String/String)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(boolean expected, boolean actual) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(boolean expected, Boolean actual) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Boolean expected, short actual) {
        handleAssertEquals("AssertEquals (Boolean/short)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Boolean expected, Boolean actual) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(boolean expected, boolean actual, String message) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(boolean expected, Boolean actual, String message) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Boolean expected, boolean actual, String message) {
        handleAssertEquals("AssertEquals (Boolean/boolean)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Boolean expected, Boolean actual, String message) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(boolean expected, boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean/boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(boolean expected, Boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean/Boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Boolean expected, boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Boolean/boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Boolean expected, Boolean actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Boolean/Boolean)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }


    public void assertEquals(Short expected, Short actual) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual);
        Assert.assertEquals(expected, actual);
    }


    public void assertEquals(Short expected, Short actual, String message) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(short expected, short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (short/short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Short expected, Short actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Short/Short)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Byte expected, Byte actual) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(byte expected, byte actual, String message) {
        handleAssertEquals("AssertEquals (byte/byte)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Byte expected, Byte actual, String message) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(byte expected, byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (byte/byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }


    public void assertEquals(Byte expected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Byte/Byte)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(int expected, int actual) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Integer expected, Integer actual) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(int expected, int actual, String message) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Integer expected, Integer actual, String message) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(int expected, int actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (int/int)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Integer expected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Integer/Integer)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(long expected, long actual) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Long expected, Long actual) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(long expected, long actual, String message) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Long expected, Long actual, String message) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(long expected, long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (long/long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Long expected, Long actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Long/Long)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(float expected, float actual) {
        handleAssertEquals("AssertEquals (float/float)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Float expected, Float actual) {
        handleAssertEquals("AssertEquals (Float/Float)", expected, actual);
        Assert.assertEquals(expected, actual);
    }


    public void assertEquals(float expected, float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (float/float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }


    public void assertEquals(Float expected, Float actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Float/Float)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(double expected, double actual) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual);
        Assert.assertEquals(expected, actual);
    }


    public void assertEquals(Double expected, Double actual) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(double expected, double actual, String message) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Double expected, Double actual, String message) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(double expected, double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (double/double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Double expected, Double actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Double/Double)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(char expected, char actual) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Character expected, Character actual) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(char expected, char actual, String message) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Character expected, Character actual, String message) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(char expected, char actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (char/char)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Character expected, Character actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Character/Character)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertEquals(Object expected, Object actual) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(Object expected, Object actual, String message) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual, message);
        Assert.assertEquals(message, expected, actual);
    }

    public void assertEquals(Object expected, Object actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Object/Object)", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual, String message) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(boolean[] expected, boolean[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (boolean[]/boolean[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(char[] expected, char[] actual) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(char[] expected, char[] actual, String message) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(char[] expected, char[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (char[]/char[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual, String message) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(byte[] expected, byte[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (byte[]/byte[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(short[] expected, short[] actual) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(short[] expected, short[] actual, String message) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(short[] expected, short[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (short[]/short[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(int[] expected, int[] actual) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(int[] expected, int[] actual, String message) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(int[] expected, int[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (int[]/int[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertArrayEquals(long[] expected, long[] actual) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(long[] expected, long[] actual, String message) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(long[] expected, long[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (long[]/long[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }


    public void assertArrayEquals(double[] expected, double[] actual) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual);
        Assert.assertArrayEquals(expected, actual, 0);
    }

    public void assertArrayEquals(double[] expected, double[] actual, String message) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual, 0);
    }

    public void assertArrayEquals(double[] expected, double[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (double[]/double[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual, 0);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual);
        Assert.assertArrayEquals(expected, actual);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual, String message) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual, message);
        Assert.assertArrayEquals(message, expected, actual);
    }

    public void assertArrayEquals(Object[] expected, Object[] actual, Supplier<String> messageSupplier) {
        handleAssertEquals("AssertEquals (Object[]/Object[])", expected, actual, buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertArrayEquals(messageSupplier.get(), expected, actual);
    }

    public void assertNotEquals(byte unexpected, byte actual) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Byte unexpected, Byte actual) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(byte unexpected, byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Byte unexpected, Byte actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(byte unexpected, byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (byte/byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Byte unexpected, Byte actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Byte/Byte)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(short unexpected, short actual) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Short unexpected, Short actual) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(short unexpected, short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Short unexpected, Short actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(short unexpected, short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (short/short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Short unexpected, Short actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Short/Short)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(int unexpected, int actual) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Integer unexpected, Integer actual) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(int unexpected, int actual, String message) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Integer unexpected, Integer actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(int unexpected, int actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (int/int)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Integer unexpected, Integer actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Integer/Integer)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(long unexpected, long actual) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(long unexpected, long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Long unexpected, Long actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Long/Long)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(long unexpected, long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (long/long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Long unexpected, Long actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Long/Long)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(float unexpected, float actual) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(float unexpected, Float actual) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, float actual) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, Float actual) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(float unexpected, float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(float unexpected, Float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, Float actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(float unexpected, float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (float/float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(float unexpected, Float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (float/Float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Float/float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Float unexpected, Float actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Float/Float)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(double unexpected, double actual) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(double unexpected, Double actual) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, double actual) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, Double actual) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(double unexpected, double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(double unexpected, Double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, Double actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(double unexpected, double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (double/double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(double unexpected, Double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (double/Double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Double/double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Double unexpected, Double actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Double/Double)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(char unexpected, char actual) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Character unexpected, Character actual) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(char unexpected, char actual, String message) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Character unexpected, Character actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(char unexpected, char actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (char/char)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Character unexpected, Character actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Character/Character)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertNotEquals(Object unexpected, Object actual) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    public void assertNotEquals(Object unexpected, Object actual, String message) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual, message);
        Assert.assertNotEquals(message, unexpected, actual);
    }

    public void assertNotEquals(Object unexpected, Object actual, Supplier<String> messageSupplier) {
        handleAssertNotEquals("AssertNotEquals (Object/Object)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotEquals(messageSupplier.get(), unexpected, actual);
    }

    public void assertSame(Object expected, Object actual) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual);
        Assert.assertSame(expected, actual);
    }

    public void assertSame(Object expected, Object actual, String message) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual, message);
        Assert.assertSame(message, expected, actual);
    }

    public void assertSame(Object expected, Object actual, Supplier<String> messageSupplier) {
        handleAssertSame("AssertSame (Object/Object)", expected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertSame(messageSupplier.get(), expected, actual);
    }

    public void assertNotSame(Object unexpected, Object actual) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual);
        Assert.assertNotSame(unexpected, actual);
    }

    public void assertNotSame(Object unexpected, Object actual, String message) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual, message);
        Assert.assertNotSame(message, unexpected, actual);
    }

    public void assertNotSame(Object unexpected, Object actual, Supplier<String> messageSupplier) {
        handleAssertNotSame("AssertNotSame (Object/Object)", unexpected, actual,
                buildPrefix(nullSafeGet(messageSupplier)));
        Assert.assertNotSame(messageSupplier.get(), unexpected, actual);
    }


    public void assertGreaterThan(Double value1, Double value2) {
        Assert.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Double value1, Double value2) {
        Assert.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(Integer value1, Integer value2) {
        Assert.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Integer value1, Integer value2) {
        Assert.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(Float value1, Float value2) {
        Assert.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(Float value1, Float value2) {
        Assert.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    public void assertGreaterThan(String value1, String value2) {
        Assert.assertEquals(true, anglesAssertGreaterThan(value1, value2));
    }

    public void assertLessThan(String value1, String value2) {
        Assert.assertEquals(true, anglesAssertLessThan(value1, value2));
    }

    private String buildPrefix(String message) {
        return StringUtils.isNotBlank(message) ? message + " ==> " : "";
    }

    private String nullSafeGet(Supplier<String> messageSupplier) {
        return messageSupplier != null ? (String) messageSupplier.get() : null;
    }
}
