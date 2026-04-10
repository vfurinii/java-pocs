package org.example.DPK5;

import org.example.DPK05.DPK05_impl_1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DPK01_impl_5 Test Suite")
class DPK05_impl_1Test {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws Exception {
        // Reset leaderBoard to initial state before each test
        Field leaderBoardField = DPK05_impl_1.class.getDeclaredField("leaderBoard");
        leaderBoardField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, Integer> leaderBoard = (Map<String, Integer>) leaderBoardField.get(null);
        leaderBoard.put("john", 0);
        leaderBoard.put("paul", 0);
        leaderBoard.put("george", 0);
        leaderBoard.put("ringo", 0);
    }

    @Nested
    @DisplayName("getPower() Tests")
    class GetPowerTests {

        @Test
        @DisplayName("Should return correct power for John")
        void shouldReturnCorrectPowerForJohn() {
            Integer power = DPK05_impl_1.getPower("john");
            assertEquals(100, power);
        }

        @Test
        @DisplayName("Should return correct power for Paul")
        void shouldReturnCorrectPowerForPaul() {
            Integer power = DPK05_impl_1.getPower("paul");
            assertEquals(90, power);
        }

        @Test
        @DisplayName("Should return correct power for George")
        void shouldReturnCorrectPowerForGeorge() {
            Integer power = DPK05_impl_1.getPower("george");
            assertEquals(80, power);
        }

        @Test
        @DisplayName("Should return correct power for Ringo")
        void shouldReturnCorrectPowerForRingo() {
            Integer power = DPK05_impl_1.getPower("ringo");
            assertEquals(70, power);
        }

        @Test
        @DisplayName("Should return null for unknown person")
        void shouldReturnNullForUnknownPerson() {
            Integer power = DPK05_impl_1.getPower("unknown");
            assertNull(power);
        }

        @Test
        @DisplayName("Should return null for empty string")
        void shouldReturnNullForEmptyString() {
            Integer power = DPK05_impl_1.getPower("");
            assertNull(power);
        }

        @Test
        @DisplayName("Should return null for null input")
        void shouldReturnNullForNullInput() {
            Integer power = DPK05_impl_1.getPower(null);
            assertNull(power);
        }
    }

    @Nested
    @DisplayName("getMostPowerful() Tests")
    class GetMostPowerfulTests {

        @Test
        @DisplayName("Should return John when comparing John and Paul")
        void shouldReturnJohnWhenComparingJohnAndPaul() {
            String result = DPK05_impl_1.getMostPowerful("john", "paul");
            assertEquals("john", result);
        }

        @Test
        @DisplayName("Should return Paul when comparing Paul and George")
        void shouldReturnPaulWhenComparingPaulAndGeorge() {
            String result = DPK05_impl_1.getMostPowerful("paul", "george");
            assertEquals("paul", result);
        }

        @Test
        @DisplayName("Should return George when comparing George and Ringo")
        void shouldReturnGeorgeWhenComparingGeorgeAndRingo() {
            String result = DPK05_impl_1.getMostPowerful("george", "ringo");
            assertEquals("george", result);
        }

        @Test
        @DisplayName("Should return John when comparing Ringo and John")
        void shouldReturnJohnWhenComparingRingoAndJohn() {
            String result = DPK05_impl_1.getMostPowerful("ringo", "john");
            assertEquals("john", result);
        }

        @Test
        @DisplayName("Should return error message when first player not found")
        void shouldReturnErrorMessageWhenFirstPlayerNotFound() {
            String result = DPK05_impl_1.getMostPowerful("unknown", "john");
            assertEquals("One or both players not found", result);
        }

        @Test
        @DisplayName("Should return error message when second player not found")
        void shouldReturnErrorMessageWhenSecondPlayerNotFound() {
            String result = DPK05_impl_1.getMostPowerful("john", "unknown");
            assertEquals("One or both players not found", result);
        }

        @Test
        @DisplayName("Should return error message when both players not found")
        void shouldReturnErrorMessageWhenBothPlayersNotFound() {
            String result = DPK05_impl_1.getMostPowerful("unknown1", "unknown2");
            assertEquals("Both players not found", result);
        }

        @Test
        @DisplayName("Should handle same person comparison")
        void shouldHandleSamePersonComparison() {
            String result = DPK05_impl_1.getMostPowerful("john", "john");
            assertEquals("john", result);
        }
    }

    @Nested
    @DisplayName("getPoints() Tests")
    class GetPointsTests {

        @Test
        @DisplayName("Should return initial points as zero for John")
        void shouldReturnInitialPointsAsZeroForJohn() {
            Integer points = DPK05_impl_1.getPoints("john");
            assertEquals(0, points);
        }

        @Test
        @DisplayName("Should return initial points as zero for Paul")
        void shouldReturnInitialPointsAsZeroForPaul() {
            Integer points = DPK05_impl_1.getPoints("paul");
            assertEquals(0, points);
        }

        @Test
        @DisplayName("Should return initial points as zero for George")
        void shouldReturnInitialPointsAsZeroForGeorge() {
            Integer points = DPK05_impl_1.getPoints("george");
            assertEquals(0, points);
        }

        @Test
        @DisplayName("Should return initial points as zero for Ringo")
        void shouldReturnInitialPointsAsZeroForRingo() {
            Integer points = DPK05_impl_1.getPoints("ringo");
            assertEquals(0, points);
        }

        @Test
        @DisplayName("Should return null for unknown person")
        void shouldReturnNullForUnknownPerson() {
            Integer points = DPK05_impl_1.getPoints("unknown");
            assertNull(points);
        }
    }

    @Nested
    @DisplayName("updateLeaderboard() Tests")
    class UpdateLeaderboardTests {

        @BeforeEach
        void setUpOutput() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("Should add points to John")
        void shouldAddPointsToJohn() {
            DPK05_impl_1.updateLeaderboard("john", 10);
            Integer points = DPK05_impl_1.getPoints("john");
            assertEquals(10, points);
            assertTrue(outputStreamCaptor.toString().contains("Adding 10 points to john"));
        }

        @Test
        @DisplayName("Should add points to Paul")
        void shouldAddPointsToPaul() {
            DPK05_impl_1.updateLeaderboard("paul", 15);
            Integer points = DPK05_impl_1.getPoints("paul");
            assertEquals(15, points);
            assertTrue(outputStreamCaptor.toString().contains("Adding 15 points to paul"));
        }

        @Test
        @DisplayName("Should remove points from George")
        void shouldRemovePointsFromGeorge() {
            DPK05_impl_1.updateLeaderboard("george", 20);
            DPK05_impl_1.updateLeaderboard("george", -5);
            Integer points = DPK05_impl_1.getPoints("george");
            assertEquals(15, points);
            assertTrue(outputStreamCaptor.toString().contains("Removing 5 points from george"));
        }

        @Test
        @DisplayName("Should handle negative points correctly")
        void shouldHandleNegativePointsCorrectly() {
            DPK05_impl_1.updateLeaderboard("ringo", -10);
            Integer points = DPK05_impl_1.getPoints("ringo");
            assertEquals(-10, points);
            assertTrue(outputStreamCaptor.toString().contains("Removing 10 points from ringo"));
        }

        @Test
        @DisplayName("Should accumulate points correctly")
        void shouldAccumulatePointsCorrectly() {
            DPK05_impl_1.updateLeaderboard("john", 10);
            DPK05_impl_1.updateLeaderboard("john", 20);
            DPK05_impl_1.updateLeaderboard("john", 15);
            Integer points = DPK05_impl_1.getPoints("john");
            assertEquals(45, points);
        }

        @Test
        @DisplayName("Should handle mixed positive and negative updates")
        void shouldHandleMixedPositiveAndNegativeUpdates() {
            DPK05_impl_1.updateLeaderboard("paul", 50);
            DPK05_impl_1.updateLeaderboard("paul", -20);
            DPK05_impl_1.updateLeaderboard("paul", 10);
            DPK05_impl_1.updateLeaderboard("paul", -5);
            Integer points = DPK05_impl_1.getPoints("paul");
            assertEquals(35, points);
        }

        @Test
        @DisplayName("Should print error message for unknown person")
        void shouldPrintErrorMessageForUnknownPerson() {
            DPK05_impl_1.updateLeaderboard("unknown", 10);
            assertTrue(outputStreamCaptor.toString().contains("Person not found in leaderboard"));
        }

        @Test
        @DisplayName("Should not update points for unknown person")
        void shouldNotUpdatePointsForUnknownPerson() {
            DPK05_impl_1.updateLeaderboard("unknown", 10);
            Integer points = DPK05_impl_1.getPoints("unknown");
            assertNull(points);
        }

        @Test
        @DisplayName("Should handle zero points update")
        void shouldHandleZeroPointsUpdate() {
            DPK05_impl_1.updateLeaderboard("john", 0);
            Integer points = DPK05_impl_1.getPoints("john");
            assertEquals(0, points);
        }

        @org.junit.jupiter.api.AfterEach
        void restoreOutput() {
            System.setOut(originalOut);
        }
    }

    @Nested
    @DisplayName("Integration Tests")
    class IntegrationTests {

        @BeforeEach
        void setUpOutput() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("Should simulate a fight between John and Paul")
        void shouldSimulateFightBetweenJohnAndPaul() {
            String winner = DPK05_impl_1.getMostPowerful("john", "paul");
            String loser = "john".equals(winner) ? "paul" : "john";

            DPK05_impl_1.updateLeaderboard(winner, 10);
            DPK05_impl_1.updateLeaderboard(loser, -5);

            assertEquals("john", winner);
            assertEquals(10, DPK05_impl_1.getPoints("john"));
            assertEquals(-5, DPK05_impl_1.getPoints("paul"));
        }

        @Test
        @DisplayName("Should simulate multiple fights with leaderboard updates")
        void shouldSimulateMultipleFightsWithLeaderboardUpdates() {
            // Fight 1: John vs Paul
            String winner1 = DPK05_impl_1.getMostPowerful("john", "paul");
            String loser1 = "john".equals(winner1) ? "paul" : "john";
            DPK05_impl_1.updateLeaderboard(winner1, 10);
            DPK05_impl_1.updateLeaderboard(loser1, -5);

            // Fight 2: George vs Ringo
            String winner2 = DPK05_impl_1.getMostPowerful("george", "ringo");
            String loser2 = "george".equals(winner2) ? "ringo" : "george";
            DPK05_impl_1.updateLeaderboard(winner2, 10);
            DPK05_impl_1.updateLeaderboard(loser2, -5);

            // Fight 3: John vs George (winners fight)
            String winner3 = DPK05_impl_1.getMostPowerful(winner1, winner2);
            String loser3 = winner1.equals(winner3) ? winner2 : winner1;
            DPK05_impl_1.updateLeaderboard(winner3, 10);
            DPK05_impl_1.updateLeaderboard(loser3, -5);

            assertEquals("john", winner1);
            assertEquals("george", winner2);
            assertEquals("john", winner3);
            assertEquals(20, DPK05_impl_1.getPoints("john"));
            assertEquals(-5, DPK05_impl_1.getPoints("paul"));
            assertEquals(5, DPK05_impl_1.getPoints("george"));
            assertEquals(-5, DPK05_impl_1.getPoints("ringo"));
        }

        @Test
        @DisplayName("Should verify all players exist in both maps")
        void shouldVerifyAllPlayersExistInBothMaps() {
            String[] players = {"john", "paul", "george", "ringo"};
            
            for (String player : players) {
                assertNotNull(DPK05_impl_1.getPower(player), "Power should exist for " + player);
                assertNotNull(DPK05_impl_1.getPoints(player), "Points should exist for " + player);
            }
        }

        @org.junit.jupiter.api.AfterEach
        void restoreOutput() {
            System.setOut(originalOut);
        }
    }
}

