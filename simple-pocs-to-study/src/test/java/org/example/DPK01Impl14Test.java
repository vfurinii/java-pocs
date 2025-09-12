package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DPK01Impl14Test {

    @Test
    public void testBasicMovement() {
        String[][] grid = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };

        int[] startPos = {0, 0};
        String[] moves = {"up", "down", "left", "right"};

        List<String> result = DPK01_impl_14.move(deepCopy(grid), startPos, moves);

        List<String> expected = Arrays.asList("Ryu", "Ken", "M.Bison");
        assertEquals(expected, result);
    }

    @Test
    public void testMoveNoOpponents() {
        String[][] grid = {
                {"", "", "", "", "", ""},
                {"", "", "", "", "", ""}
        };

        int[] startPos = {0, 0};
        String[] moves = {"right", "right", "right"};

        List<String> result = DPK01_impl_14.move(deepCopy(grid), startPos, moves);

        List<String> expected = new ArrayList<>();
        assertEquals(expected, result);
    }

    @Test
    public void testWrappingLeftRight() {
        String[][] grid = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };

        int[] startPos = {0, 0};
        String[] moves = {"left"};

        List<String> result = DPK01_impl_14.move(deepCopy(grid), startPos, moves);

        List<String> expected = List.of("Vega");
        assertEquals(expected, result);
    }
    private String[][] deepCopy(String[][] original) {
        String[][] copy = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}