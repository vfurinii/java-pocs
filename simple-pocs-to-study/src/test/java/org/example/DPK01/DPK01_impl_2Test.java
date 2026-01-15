package org.example.DPK01;

import org.junit.Test;

public class DPK01_impl_2Test {

    @Test
    public void testRevert() {
        assert DPK01_impl_2.revert("hello").equals("olleh");
        assert DPK01_impl_2.revert("").equals("");
        assert DPK01_impl_2.revert(null) == null;
        assert DPK01_impl_2.revert("A").equals("A");
        assert DPK01_impl_2.revert("racecar").equals("racecar");
    }

}