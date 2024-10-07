package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

import Model.GameOfCrap;

public class CrapsFrame extends JPanel implements PropertyChangeListener {
    private JMenuBar myMenuBar;
    private JMenu myGameMenu;
    private JMenuItem myStart = new JMenuItem("Start");
    private JMenuItem myReset = new JMenuItem("Reset");
    private JMenuItem myExit = new JMenuItem("Exit");
    private JMenu myHelpMenu;
    private JMenuItem myAbout = new JMenuItem("About");
    private JMenuItem myRules = new JMenuItem("Rules");
    private JToolBar myBottomToolbar1;
    private JToolBar myBottomToolbar2;
    private JSplitPane mySplitPane;
    private JPanel myTopPanel;
    private JPanel myBottomPanel;
    private JLabel myDice1 = new JLabel("Dice 1:");
    private JTextField myNumer1 = new JTextField(1);
    private JLabel myDice2 = new JLabel("Dice 2:");
    private JTextField myNumer2 = new JTextField(1);
    private JLabel myTotal = new JLabel("Total:");
    private JTextField myNumerTotal = new JTextField(2);
    private JLabel myPoint = new JLabel("Point:");
    private JTextField myNumberPoint = new JTextField(2);
    private JButton myRoll = new JButton("Roll");
    private JButton myPlayAgain = new JButton("Play Again");
    private JLabel myWinLabel = new JLabel("Wins: ");
    private JTextField myWinField = new JTextField("0");
    private JLabel myLoseLabel = new JLabel("House wins: ");
    private JTextField myLoseField = new JTextField("0");
    private JLabel myBank = new JLabel("Bank $");
    private JTextField myBankField = new JTextField();
    private JButton mySetBank = new JButton("Set Bank");
    private JLabel myBet = new JLabel(" Bet: $");
    private JTextField myBetField = new JTextField();
    private JButton mySetBet = new JButton("Set Bet");

    public CrapsFrame() {
        //layout here
        // Create menu
        myMenuBar = new JMenuBar();
        myGameMenu = new JMenu("Game");
        myMenuBar.add(myGameMenu);
        myGameMenu.add(myStart);
        myGameMenu.add(myReset);
        myGameMenu.add(myExit);
        myHelpMenu = new JMenu("Help");
        myMenuBar.add(myHelpMenu);
        myHelpMenu.add(myAbout);
        myHelpMenu.add(myRules);
        myStart.setMnemonic(KeyEvent.VK_S);
        myStart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));

        myReset.setMnemonic(KeyEvent.VK_R);
        myReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));

        myExit.setMnemonic(KeyEvent.VK_E);
        myExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));

        myAbout.setMnemonic(KeyEvent.VK_A);
        myAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));

        myRules.setMnemonic(KeyEvent.VK_U);
        myRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));


        // Create toolbars
        myBottomToolbar1 = new JToolBar();
        myBottomToolbar2 = new JToolBar();
        myBottomToolbar1.add(myBank);
        myBottomToolbar1.add(myBankField);
        myBottomToolbar1.add(mySetBank);
        myBottomToolbar1.add(myBet);
        myBottomToolbar1.add(myBetField);
        myBottomToolbar1.add(mySetBet);
        myBottomToolbar2.add(myWinLabel);
        myBottomToolbar2.add(myWinField);
        myBottomToolbar2.add(myLoseLabel);
        myBottomToolbar2.add(myLoseField);

        // Create split pane
        mySplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        myTopPanel= new JPanel();
        myBottomPanel = new JPanel();
        mySplitPane.setTopComponent(myTopPanel);
        mySplitPane.setBottomComponent(myBottomPanel);

        // Layout
        setLayout(new BorderLayout());
        add(myMenuBar, BorderLayout.NORTH);
        add(mySplitPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(myBottomToolbar1);
        southPanel.add(myBottomToolbar2);
        add(southPanel,BorderLayout.SOUTH);
        myTopPanel.add(myRoll);
        myTopPanel.add(myPoint);
        myTopPanel.add(myNumberPoint);
        myBottomPanel.add(myPlayAgain);
        myBottomPanel.add(myDice1);
        myBottomPanel.add(myNumer1);
        myBottomPanel.add(myDice2);
        myBottomPanel.add(myNumer2);
        myBottomPanel.add(myTotal);
        myBottomPanel.add(myNumerTotal);

        myRoll.setMnemonic(KeyEvent.VK_O);
        myPlayAgain.setMnemonic(KeyEvent.VK_P);
        mySetBank.setMnemonic(KeyEvent.VK_B);
        mySetBet.setMnemonic(KeyEvent.VK_M);

        addListeners();
        gamerun();
        myNumer1.setEditable(false);
        myNumer2.setEditable(false);
        myNumerTotal.setEditable(false);
        myWinField.setEditable(false);
        myLoseField.setEditable(false);
        myNumberPoint.setEditable(false);
        myRoll.setEnabled(false);
        myPlayAgain.setEnabled(false);
        myReset.setEnabled(false);
        myStart.setEnabled(false);
        myBetField.setEditable(false);

    }
    private void gamerun(){
        JOptionPane.showMessageDialog(null, "please set the bank and bet amount before playing.");
    }

    // tester for model and javadoc everthing
    // write reflection

    private void addListeners() {
        myAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Developer: Hamda Jama\n" +
                        "Version: 2.0\n" +
                        "Java Version: " + System.getProperty("java.version") + "\n" +
                        "Description: A game of Craps");
            }
        });
        myRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Game Rules:\n" +
                        "1. Set your initial bank and bet amount.\n" +
                        "2. Click 'Start' to begin the game.\n" +
                        "3. Roll the dice and try to win by getting specific numbers.\n"+
                        "  * If the total is 7 or 11 on the first throw or roll the player wins.\n"+
                        "  * If the total is 2, 3, or 12 on the first throw or roll the player losses and the house wins.\n"+
                        "  * If the total is 4, 5, 6, 8, 9, 10 the total becomes the players point.\n"+
                        "  * Keep rolling if the player gets a total that is the same as their point they win.\n "+
                        "  * If they get a 7 before the total is the same as their point then the house wins and the player losses.\n"+
                        "4. Have fun and Good Luck!");
            }
        });
        myBankField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(myBankField.getText());
                    if (number > 0) {
                        GameOfCrap crap = GameOfCrap.getMyInstance();
                        crap.setMyStartingBank(number);
                        JOptionPane.showMessageDialog(null, "Starting bank updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number for the starting bank.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the starting bank.");
                }
            }
        });
        myBetField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bet = Integer.parseInt(myBetField.getText());
                    GameOfCrap crap = GameOfCrap.getMyInstance();
                    if (bet > 0 && bet <= crap.getMyBank()) {
                        crap.setMyBet(bet);
                        myBankField.setText(String.valueOf(crap.getMyBank()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid bet amount!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the bet.");
                }
                myStart.setEnabled(true);
            }
        });
        mySetBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myBetField.setEditable(false);
            }
        });
        mySetBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myBankField.setEditable(false);
                myBetField.setEditable(true);
            }
        });

        myStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOfCrap.getMyInstance().startGame();
                myRoll.setEnabled(true);
                myPlayAgain.setEnabled(false);
            }
        });

        myRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                GameOfCrap crap = GameOfCrap.getMyInstance();

                if (crap.getMyActive()) {
                    crap.roll();
                    myNumer1.setText(String.valueOf(crap.getMyDice1()));
                    myNumer2.setText(String.valueOf(crap.getMyDice2()));
                    myNumerTotal.setText(String.valueOf(crap.getMyTotal()));
                    if (crap.getMyBank() <= 0) {
                        // User has no more money, end the session
                        JOptionPane.showMessageDialog(null, "Game over! Your bank is empty.");
                        endGameSession();
                    } else {
                        if (crap.getWon()) {
                            JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                            // Increment win count
                            myWinField.setText(String.valueOf(crap.getMyWin()));
                            crap.updateBank();
                            myBankField.setText(String.valueOf(crap.getMyBank()));
                        } else if (crap.getMyPoint() != 0) {
                            myNumberPoint.setText(String.valueOf(crap.getMyPoint()));
                            if (crap.getMyTotal() == 7) {
                                JOptionPane.showMessageDialog(null, "You rolled a 7. The house wins.");
                                crap.updateBank();
                                myBankField.setText(String.valueOf(crap.getMyBank()));
                                myLoseField.setText(String.valueOf(crap.getMyLose()));
                                myNumberPoint.setText(String.valueOf(crap.getMyPoint()));
                                // Disable the "Roll" button when the game ends
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry, you lose. The house wins.");
                            // Increment loss count
                            myLoseField.setText(String.valueOf(crap.getMyLose()));
                            crap.updateBank();
                            myBankField.setText(String.valueOf(crap.getMyBank()));
                        }
                    }

                    myPlayAgain.setEnabled(true);
                    updateRollButtonState();
                }
            }
        });
        myNumberPoint.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                GameOfCrap crap = GameOfCrap.getMyInstance();
                if (Objects.equals(evt.getPropertyName(), "pointSet")) {
                    int newPoint = (int) evt.getNewValue();

                    // Show JOptionPane when point equals new total
                    if (newPoint == crap.getMyTotal()) {
                        JOptionPane.showMessageDialog(null, "You rolled your point. You win!");
                        crap.updateBank();
                        myBankField.setText(String.valueOf(crap.getMyBank()));
                        myWinField.setText(String.valueOf(crap.getMyWin()));
                        myNumberPoint.setText(String.valueOf(crap.getMyPoint()));
                        myPlayAgain.setEnabled(true);
                        myRoll.setEnabled(false); // Disable the "Roll" button when the game ends
                    }
                    // Enable "Roll" button when a point is set and the game is still active
                    else {
                        updateRollButtonState();
                    }
                }
            }
        });
        myPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myRoll.setEnabled(true);
                myPlayAgain.setEnabled(false);
                myReset.setEnabled(true);
                myStart.setEnabled(false);
                myNumer1.setText("");
                myNumer2.setText("");
                myNumerTotal.setText("");
                myNumberPoint.setText("");
                myBetField.setText("");
                myBetField.setEditable(true);
                GameOfCrap.getMyInstance().startGame();
            }
        });
        myReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOfCrap.getMyInstance().startGame();
                // Clear win totals
                myWinField.setText("0");
                myLoseField.setText("0");
                // Enable Roll button and disable Play Again button
                myRoll.setEnabled(true);
                myPlayAgain.setEnabled(false);
                // Clear displayed values
                myNumer1.setText("");
                myNumer2.setText("");
                myNumerTotal.setText("");
                myNumberPoint.setText("");
                myBankField.setText("");
                myBetField.setText("");
                myBankField.setEditable(true);
                myBetField.setEditable(true);
            }
        });
        myExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pick = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the game?"
                );
                if (pick == JOptionPane.YES_OPTION) {
                    // Get the frame and close it
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CrapsFrame.this);
                    frame.dispose();
                }
            }
        });

    }
    private void endGameSession(){
        myRoll.setEnabled(false);
        myPlayAgain.setEnabled(false);
        myBankField.setEditable(true);
        myBetField.setEditable(true);
    }
    // Helper method to update the state of the "Roll" button
    private void updateRollButtonState() {
        GameOfCrap crap = GameOfCrap.getMyInstance();
        if (crap.getMyPoint() != 0 && crap.getMyActive()) {
            myRoll.setEnabled(true);
        } else {
            myRoll.setEnabled(false);
        }
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       if(evt.getPropertyName() == "ative") {
           if((boolean) evt.getNewValue() == false) {
               myRoll.setEnabled(false);
               JOptionPane.showMessageDialog(null,"Game not active!");
           }
       }
    }
}

