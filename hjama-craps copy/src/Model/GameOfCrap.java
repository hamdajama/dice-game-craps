package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.function.Supplier;

/**
 * the class represents a simplified implementation of the game of Craps.
 * @author Hamda Jama
 * @version 2.0
 */
public class GameOfCrap {
    private PropertyChangeSupport change = new PropertyChangeSupport(this);
    private static Random random = new Random();
    private int myDice1;
    private int myDice2;
    private int myTotal;
    private int myPoint;
    private boolean myActive;
    private boolean myWon;
    private int myWin;
    private int myLose;
    private int myStartingBank;
    private int myBank;
    private int myBet;
    private static GameOfCrap myInstance = new GameOfCrap();

    private GameOfCrap() {
        startGame();
    }
    /**
     * Returns the single instance of the GameOfCrap class.
     *
     * @return The single instance of GameOfCrap.
     */
    public static GameOfCrap getMyInstance() {
        return myInstance;
    }
    /**
     * Starts a new game by setting the game to active, resetting won status, and resetting the point.
     */
    public void startGame() {
        setActive(true);
        setWon(false);
        setPoint(0);
    }
    /**
     * Sets the game's active status and fires a property change event if it becomes inactive.
     *
     * @param theActive The new active status.
     */
    public void setActive(final boolean theActive) {
        myActive = theActive;
        if (!myActive) {
            change.firePropertyChange("active", null, false);
        }
    }
    /**
     * Sets the game's won status.
     *
     * @param theWon The new won status.
     */
    public void setWon(final boolean theWon) {
        myWon = theWon;
    }
    /**
     * Sets the point and fires a property change event for point set.
     *
     * @param thePoint The new point value.
     */
    public void setPoint(final int thePoint) {
        int oldPoint = myPoint;
        myPoint = thePoint;
        change.firePropertyChange("pointSet", oldPoint, myPoint);
    }
    /**
     * Sets the total value of the dice.
     *
     * @param theTotal The new total value.
     */
    public void setTotal(final int theTotal) {
        myTotal = theTotal;
    }
    /**
     * Sets the initial bank balance and the current bank balance.
     *
     * @param theStartingBank The initial bank balance.
     */
    public void setMyStartingBank(final int theStartingBank) {
        myStartingBank = theStartingBank;
        myBank = myStartingBank;

    }
    /**
     * Sets the player's bet amount and deducts it from the bank balance.
     *
     * @param theBetAmount The bet amount.
     */
     public void setMyBet(int theBetAmount) {
         if (theBetAmount > 0 && theBetAmount <= myBank) {
             myBet = theBetAmount;
             myBank -= myBet; // Deduct the bet amount from the bank
         }
     }
    /**
     * Sets the bank balance to the specified amount.
     *
     * @param theBankAmount The new bank balance.
     */
    public void setMyBank(int theBankAmount) {
        myBank = theBankAmount;
    }

    /**
     * Sets the value of the first die.
     *
     * @param theDice1 The value of the first die.
     */
    public void setMyDice1(int theDice1) {
        myDice1 = theDice1;
    }
    /**
     * Sets the value of the second die.
     *
     * @param theDice2 The value of the second die.
     */
    public void setMyDice2(int theDice2) {
        myDice2 = theDice2;
    }
    /**
     * Gets the current bank balance.
     *
     * @return The current bank balance.
     */
    public int getMyBank() {
        return myBank;
    }
    /**
     * Gets the current bet amount.
     *
     * @return The current bet amount.
     */
    public int getMyBet() {
        return myBet;
    }
    /**
     * Generates and returns a random number representing a dice roll.
     *
     * @return A random dice roll value.
     */
    public int getMyRollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    /**
     * Sets the rollDice value using a custom Supplier for testing purposes.
     *
     * @param customRollDice The custom Supplier providing the rollDice value.
     */
    public void setRollDice(Supplier<Integer> customRollDice) {
        customRollDice.get();
    }
    /**
     * Gets the current point value.
     *
     * @return The current point value.
     */
    public int getMyPoint() {
        return myPoint;
    }
    /**
     * Gets the total value of the dice.
     *
     * @return The total value of the dice.
     */
    public int getMyTotal() {
        return myTotal;
    }

    /**
     * Gets the value of the first die.
     *
     * @return The value of the first die.
     */
    public int getMyDice1() {
        return myDice1;
    }
    /**
     * Gets the value of the second die.
     *
     * @return The value of the second die.
     */
    public int getMyDice2() {
        return myDice2;
    }

    /**
     * Checks if the game is currently active.
     *
     * @return True if the game is active, false otherwise.
     */
    public boolean getMyActive() {
        return myActive;
    }
    /**
     * Gets the total number of wins.
     *
     * @return The total number of wins.
     */
    public boolean getWon() {
        return myWon;
    }

    public int getMyWin() {
        return myWin;
    }
    /**
     * Gets the total number of losses.
     *
     * @return The total number of losses.
     */
    public int getMyLose() {
        return myLose;
    }
    /**
     * Updates the bank balance based on the outcome of the last game.
     */
    public void updateBank() {
        if (getWon()) {
            setMyBank(getMyBank() + getMyBet() * 2);
        } else {
            setMyBank(getMyBank() - getMyBet());
        }
    }
    /**
     * Simulates a game round by rolling two dice and determining the outcome based on Craps rules.
     * Updates game state, including point, total, won status, and player statistics.
     */
    public void roll() {
        myDice1 = getMyRollDice();
        myDice2 = getMyRollDice();
        setTotal(myDice1 + myDice2);

        if (getMyPoint() == 0) {
            // Check for win or loss on the first throw
            if (myTotal == 7 || myTotal == 11) {
                setWon(true);
                setActive(false);
                myWin++;
                setPoint(0);
            } else if (myTotal == 2 || myTotal == 3 || myTotal == 12) {
                setWon(false);
                setActive(false);
                myLose++;
                setPoint(0);
            } else {
                // Set the point for subsequent rolls
                setPoint(myTotal);
            }
        } else {
            // Continue rolling until a win or loss
            while (true) {
                myDice1 = random.nextInt(6) + 1;
                myDice2 = random.nextInt(6) + 1;
                setTotal(myDice1 + myDice2);

                if (myTotal == getMyPoint()) {
                    setWon(true);
                    setActive(false);
                    myWin++;
                    break; // Player wins
                } else if (myTotal == 7) {
                    setWon(false);
                    setActive(false);
                    myLose++;
                    break; // Player loses
                }
                // Continue rolling for the point
            }
        }
    }
    /**
     * Adds a PropertyChangeListener to the list of listeners for property change events.
     *
     * @param l The PropertyChangeListener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener l){change.addPropertyChangeListener(l);}
    /**
     * Removes a PropertyChangeListener from the list of listeners for property change events.
     *
     * @param l The PropertyChangeListener to be removed.
     */
    public void removePropertyChangeListener(PropertyChangeListener l){change.removePropertyChangeListener(l);}


}