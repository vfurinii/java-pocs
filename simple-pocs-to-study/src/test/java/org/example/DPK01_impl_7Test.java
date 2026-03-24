package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DPK01_impl_7Test {

    @Test
    void shouldGroupArrayIntoEqualSizedGroups() {
        String[] input = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"1", "2", "3"}, result[0]);
        assertArrayEquals(new String[]{"4", "5", "6"}, result[1]);
        assertArrayEquals(new String[]{"7", "8", "9"}, result[2]);
    }

    @Test
    void shouldGroupArrayWithRemainder() {
        String[] input = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(4, result.length);
        assertArrayEquals(new String[]{"1", "2", "3"}, result[0]);
        assertArrayEquals(new String[]{"4", "5", "6"}, result[1]);
        assertArrayEquals(new String[]{"7", "8", "9"}, result[2]);
        assertArrayEquals(new String[]{"10"}, result[3]);
    }

    @Test
    void shouldGroupLettersArray() {
        String[] input = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(4, result.length);
        assertArrayEquals(new String[]{"a", "b", "c"}, result[0]);
        assertArrayEquals(new String[]{"d", "e", "f"}, result[1]);
        assertArrayEquals(new String[]{"g", "h", "i"}, result[2]);
        assertArrayEquals(new String[]{"j"}, result[3]);
    }

    @Test
    void shouldGroupArrayWithGroupSizeOne() {
        String[] input = {"1", "2", "3"};
        int groupSize = 1;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"1"}, result[0]);
        assertArrayEquals(new String[]{"2"}, result[1]);
        assertArrayEquals(new String[]{"3"}, result[2]);
    }

    @Test
    void shouldReturnSingleGroupWhenGroupSizeIsLargerThanArrayLength() {
        String[] input = {"1", "2", "3"};
        int groupSize = 10;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(1, result.length);
        assertArrayEquals(new String[]{"1", "2", "3"}, result[0]);
    }

    @Test
    void shouldHandleEmptyArray() {
        String[] input = {};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(0, result.length);
    }

    @Test
    void shouldGroupArrayWhenSizeIsPerfectMultiple() {
        String[] input = {"1", "2", "3", "4", "5", "6"};
        int groupSize = 2;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"1", "2"}, result[0]);
        assertArrayEquals(new String[]{"3", "4"}, result[1]);
        assertArrayEquals(new String[]{"5", "6"}, result[2]);
    }

    @Test
    void shouldGroupLargeArray() {
        String[] input = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(4, result.length);
        assertArrayEquals(new String[]{"11", "12", "13"}, result[0]);
        assertArrayEquals(new String[]{"14", "15", "16"}, result[1]);
        assertArrayEquals(new String[]{"17", "18", "19"}, result[2]);
        assertArrayEquals(new String[]{"20"}, result[3]);
    }

    @Test
    void shouldGroupSingleElementArray() {
        String[] input = {"1"};
        int groupSize = 3;

        String[][] result = DPK01_impl_7.groupBy(input, groupSize);

        assertEquals(1, result.length);
        assertArrayEquals(new String[]{"1"}, result[0]);
    }
}

