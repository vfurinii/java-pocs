package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_4Test {

    @Test
    public void revert() {
        assertEquals("olleh", DPK01_impl_4.revertString("hello"));
        assertEquals("", DPK01_impl_4.revertString(""));
        assertNull(DPK01_impl_4.revertString(null));
        assertEquals("A", DPK01_impl_4.revertString("A"));
        assertEquals("racecar", DPK01_impl_4.revertString("racecar"));
    }

    @Test
    public void revertStringWithSpaces() {
        assertEquals("  ", DPK01_impl_4.revertString("  "));
        assertEquals(" !dlroW olleH", DPK01_impl_4.revertString("Hello World! "));
    }
}
