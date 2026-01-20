package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_4Test {

    @Test
    public void revert() {
        assertEquals("olleh", DPK01_impl_4.revert("hello"));
        assertEquals("", DPK01_impl_4.revert(""));
        assertNull(DPK01_impl_4.revert(null));
        assertEquals("A", DPK01_impl_4.revert("A"));
        assertEquals("racecar", DPK01_impl_4.revert("racecar"));
    }

    @Test
    public void revertStringWithSpaces() {
        assertEquals("  ", DPK01_impl_4.revert("  "));
        assertEquals(" !dlroW olleH", DPK01_impl_4.revert("Hello World! "));
    }
}
