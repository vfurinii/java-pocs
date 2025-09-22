package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_1Test {

    @Test
    public void revertString() {

        assertEquals("!dlroW olleH", DPK01_impl_1.revertString("Hello World!"));
        assertEquals("54321", DPK01_impl_1.revertString("12345"));
        assertEquals("", DPK01_impl_1.revertString(""));
        assertEquals("a", DPK01_impl_1.revertString("a"));
        assertEquals("racecar", DPK01_impl_1.revertString("racecar"));
    }
}