package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_1Test {

    private DPK01_impl_1 dpk01 = new DPK01_impl_1();

    @Test
    public void revertStringHelloWithSuccess() {
        String input = "hello";
        String expected = "olleh";
        String actual = dpk01.revertString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void revertStringEmptyWithSuccess() {
        String input = "";
        String expected = "";
        String actual = dpk01.revertString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void revertStringNullWithSuccess() {
        String input = null;
        String actual = dpk01.revertString(input);
        assertNull(actual);
    }

    @Test
    public void revertStringPalindromeWithSuccess() {
        String input = "madam";
        String expected = "madam";
        String actual = dpk01.revertString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void revertString() {

        assertEquals("!dlroW olleH", DPK01_impl_1.revertString("Hello World!"));
        assertEquals("54321", DPK01_impl_1.revertString("12345"));
        assertEquals("", DPK01_impl_1.revertString(""));
        assertEquals("a", DPK01_impl_1.revertString("a"));
        assertEquals("racecar", DPK01_impl_1.revertString("racecar"));
    }
}