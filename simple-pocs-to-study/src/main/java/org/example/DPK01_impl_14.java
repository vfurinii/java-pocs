package org.example;

import java.util.ArrayList;
import java.util.List;

public class DPK01_impl_14 {

    public static List<String> move(String[][] grid, int[] startPos, String[] moves) {
        int rows = grid.length;
        int cols = grid[0].length;

        int row = startPos[0];
        int col = startPos[1];

        List<String> beaten = new ArrayList<>();

        for (String move : moves) {
            switch (move.toLowerCase()) {
                case "up":
                    if (row > 0) {
                        row--;
                    }
                    break;
                case "down":
                    if (row < rows - 1) {
                        row++;
                    }
                    break;
                case "left":
                    col = (col - 1 + cols) % cols;
                    break;
                case "right":
                    col = (col + 1) % cols;
                    break;
            }
            if (!grid[row][col].isEmpty()) {
                beaten.add(grid[row][col]);
                grid[row][col] = "";
            }
        }

        return beaten;
    }
}
