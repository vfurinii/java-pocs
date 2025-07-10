package org.example;

/**
 * Class responsible for calculating the minimum amount of health points (HP)
 * a knight needs to rescue the princess from a dungeon.
 */
public class Main {

    /**
     * This method calculates the minimum initial health the knigth needs
     * in order to reach the princess alive, moving only to right or down.
     *
     * @param dungeon 2D matrix representing the dungeon
     * @return Minimum initial HP required to start the journey.
     */
    public int calculateMinimumHP(int[][] dungeon) {
        //number of rows
        int m = dungeon.length;
        //number of columns
        int n = dungeon[0].length;

        // dp[i][j] stores the minimum HP required to enter room (i, j) and survive to the end
        //dp = dinamyc programming matrix
        int[][] dp = new int[m][n];

        //calculate the princess cell bottom-right
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        //set the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        //set last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        //set the rest of the DP matrix (from bottom-right to top-left)
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHPOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);

                //calculate the minimum HP needed to enter this room
                dp[i][j] = Math.max(1, minHPOnExit - dungeon[i][j]);
            }
        }

        //returns the minimum HP needed to start at position (0, 0)
        return dp[0][0];
    }

    /**
     * Main method to run the program with a sample input.
     */
    public static void main(String[] args) {
        Main game = new Main();

        // input 3x3 with random values
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        //calls the method to calculate the minimumm required hp
        int result = game.calculateMinimumHP(dungeon);

        //print result
        System.out.println("Minimum initial health required: " + result);
    }
}
