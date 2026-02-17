package org.example.DPK02;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPK02_impl_1Test {

    @Test
    public void pattern_matcher() {
        assertEquals("English", DPK02_impl_1.pattern_matcher("USA"));
        assertEquals("Portuguese", DPK02_impl_1.pattern_matcher("Brazil"));
        assertEquals("Spanish", DPK02_impl_1.pattern_matcher("Spain"));
        assertEquals("Italian", DPK02_impl_1.pattern_matcher("Italy"));
        assertEquals("French", DPK02_impl_1.pattern_matcher("France"));
        assertEquals("German", DPK02_impl_1.pattern_matcher("Germany"));
        assertEquals("Unknown Country", DPK02_impl_1.pattern_matcher("Unknown"));
    }
}