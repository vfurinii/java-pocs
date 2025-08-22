package org.stress.poc.game;

import lombok.Data;
import org.stress.poc.model.DungeonGameRequest;
import org.stress.poc.model.DungeonGameResponse;
import org.stress.poc.service.DungeonGameService;

@Data
public class DungeonGame {

    private DungeonGameService dungeonGameService;

    public DungeonGameResponse calculateMinimumHealth(DungeonGameRequest request) {
        var dungeon = request.getDungeon();

        if (null == dungeon || dungeon.isEmpty() || dungeon.getFirst().isEmpty()) {
            var minimalHealth = 1;
            dungeonGameService.save();
            return new DungeonGameResponse(request.getId(), minimalHealth, dungeon);
        }

        int m = dungeon.size();
        int n = dungeon.getFirst().size();
        System.out.print("Dungeon: ");
        //printDungeon(dungeon);

        // dp[i][j] represents the minimum health needed to reach the princess from cell (i,j)
        int[][] dp = new int[m][n];
        System.out.print("Start new board: ");
//        printDungeon(dp);
//
        // Start from the princess' cell (bottom-right)
        dp[m-1][n-1] = Math.max(1, 1 - dungeon.get(m-1).get(n-1));
        System.out.print("Fill last cell: ");
//        printDungeon(dp);

        // Fill the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon.get(i).get(n-1));
        }
        System.out.print("Fill last column: ");
//        printDungeon(dp);

        // Fill the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon.get(m-1).get(j));
        }
        System.out.print("Fill last row: ");
//        printDungeon(dp);

        // Fill the rest of the dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon.get(i).get(j));
            }
        }
        System.out.print("Remaining board: ");
//        printDungeon(dp);

        var minimalHealth = dp[0][0];
        //createGame(request, minimalHealth);

        return new DungeonGameResponse(request.getId(), minimalHealth, dungeon);
    }
}
