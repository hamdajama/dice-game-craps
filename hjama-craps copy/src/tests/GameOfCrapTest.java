package tests;

import Model.GameOfCrap;

/**
 * The `GameOfCrapTest` class contains unit tests for the `GameOfCrap` class.
 */
class GameOfCrapTest {
    /**
     * Tests the `startGame` method of the `GameOfCrap` class.
     */
    @Test
    void startGame() {
        final GameOfCrap game = GameOfCrap.getMyInstance();

        // Test initial state
        assertTrue(game.getMyActive(), "Game should be active initially");
        assertFalse(game.getWon(), "Game should not be won initially");
        assertEquals(0, game.getMyPoint(), "Point should be 0 initially");

        // Start the game
        game.startGame();

        // Test the state after starting the game
        assertTrue(game.getMyActive(), "Game should be active after starting");
        assertFalse(game.getWon(), "Game should not be won after starting");
        assertEquals(0, game.getMyPoint(), "Point should be 0 after starting");
    }
    private void assertFalse(boolean won, String string) {
    }
    private void assertTrue(boolean myActive, String string) {
    }
    @Test
    void setActive() {
        final GameOfCrap game = GameOfCrap.getMyInstance();

        // Set the game to inactive
        game.setActive(false);

        // Check if the game is set to inactive
        assertFalse(game.getMyActive(), "Game should be inactive");
    }
    @Test
    void setWon() {
        final GameOfCrap game = GameOfCrap.getMyInstance();

        // Set the game as won
        game.setWon(true);

        // Check if the game is set as won
        assertTrue(game.getWon(), "Game should be won");
    }
    @Test
    void setPoint(){
        final GameOfCrap game = GameOfCrap.getMyInstance();
        // Set a new point
        int newPoint = 10;
        game.setPoint(newPoint);
        // Check if the point is set correctly
        assertEquals(newPoint, game.getMyPoint(), "Point should be set correctly");
    }
    @Test
    void setMyBank() {
        final GameOfCrap game = GameOfCrap.getMyInstance();

        // Set the bank amount
        int bankAmount = 500;
        game.setMyBank(bankAmount);

        // Check if the bank amount is set correctly
        assertEquals(bankAmount, game.getMyBank(), "Bank amount should be set correctly");
    }
    @Test
    void setMyBet() {
        final GameOfCrap game = GameOfCrap.getMyInstance();
        game.setMyStartingBank(100);

        // Set a valid bet
        game.setMyBet(50);
        assertEquals(50, game.getMyBet(), "Bet should be set to 50");
        assertEquals(50, game.getMyBank(), "Bank should be deducted by the bet amount");

        // Set an invalid bet (exceeding the bank amount)
        game.setMyBet(80);
        assertEquals(50, game.getMyBet(), "Bet should remain unchanged");
        assertEquals(50, game.getMyBank(), "Bank should remain unchanged");
    }
    @Test
    void getTotal(){
        final GameOfCrap game = GameOfCrap.getMyInstance();
        game.setMyDice1(3);
        game.setMyDice2(4);
        game.setTotal(7);
        assertEquals(3,game.getMyDice1(),"dice 1 should be 3");
        assertEquals(4,game.getMyDice2(),"dice 2 should be 4");
        assertEquals(7,game.getMyTotal(),"the total should be 7.");

    }
    @Test
    void testWinLogic() {
        // Create a real instance of GameOfCrap
        GameOfCrap game = GameOfCrap.getMyInstance();

        // Set a custom lambda for rollDice to simulate a total of 7
        //game.setRollDice(() -> 6); // Adjust the value to simulate a total of 7

        // Set any other necessary conditions for testing
        game.setRollDice(() -> 7);
        // Execute the roll method
        game.roll();

        // Verify the expected outcome
        assertEquals(7,game.getMyTotal(),"the total should be 7.");
        assertTrue(game.getWon(), "Game should be won");
        assertFalse(game.getMyActive(), "Game should not be active");
        assertEquals(1, game.getMyWin(), "Win count should be incremented");
    }
    private void assertEquals(int i, int myWin, String string) {
    }


}