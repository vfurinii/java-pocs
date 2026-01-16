package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_3Test {

    @Test
    public void revert() {
        assertEquals("olleh", DPK01_impl_3.revert("hello"));
        assertEquals("", DPK01_impl_3.revert(""));
        assertNull(DPK01_impl_3.revert(null));
        assertEquals("A", DPK01_impl_3.revert("A"));
        assertEquals("racecar", DPK01_impl_3.revert("racecar"));
    }

    @Test
    public void revertStringWithSpaces() {
        assertEquals("  ", DPK01_impl_3.revert("  "));
        assertEquals(" !dlroW olleH", DPK01_impl_3.revert("Hello World! "));
    }
}