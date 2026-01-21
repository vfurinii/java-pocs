package org.example.DPK01;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK01_impl_5Test {
    @Test
    public void revert() {
        assertEquals("dcba", DPK01_impl_5.revert("abcd"));
        assertEquals("", DPK01_impl_5.revert(""));
        assertEquals(null, DPK01_impl_5.revert(null));
        assertEquals("a", DPK01_impl_5.revert("a"));
        assertEquals("987654321", DPK01_impl_5.revert("123456789"));
    }


}