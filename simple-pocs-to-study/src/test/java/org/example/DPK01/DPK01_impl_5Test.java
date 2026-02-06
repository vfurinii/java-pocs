package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_5Test {

    @Test
    public void revert() {
        assertEquals("olleh", DPK01_impl_5.revert("hello"));
        assertEquals("", DPK01_impl_5.revert(""));
        assertNull(DPK01_impl_5.revert(null));
        assertEquals("A", DPK01_impl_5.revert("A"));
        assertEquals("racecar", DPK01_impl_5.revert("racecar"));
    }

    @Test
    public void revertStringWithSpaces() {
        assertEquals("  ", DPK01_impl_5.revert("  "));
        assertEquals(" !dlroW olleH", DPK01_impl_5.revert("Hello World! "));
    }
}
