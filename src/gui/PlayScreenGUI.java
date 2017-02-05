/***************************************************************
* file: PlayScreenGUI.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* class: CS 245 – Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/25/2016
*
* purpose: This program displays the play screen of the hangman
* game and acts as the game engine.
*
****************************************************************/ 
package gui;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import other.Info;

public class PlayScreenGUI extends javax.swing.JFrame {
   
    //private ColorGameGUI colorGame; // To create new Color Game.
    Thread currentTime;
    private char guessLetter; // User's input.
    private char[] currentAnswer; // User's current answer. Dynamically changes.
    private char[] answer; // Word that is chosed randomly and converted into an array of characters.
    private String chosenWord; // Randomly chosen word.
    private int finalScore; // Final score of the user.
    private int currentScore; // User's current score. Dynamically changes.
    private boolean guess; // Use to indicate whether the user guessed a correct letter.
    private int loseCount; // How many times the user guessed incorrectly.
    // Word bank where all the possible words are stored.
    private final String [] WORD_BANK = {"ABSTRACT", "CEMETERY", 
        "NURSE", "PHARMACY", "CLIMBING"};
    private final int MINUS = 10; // Each time user guesses incorrectly, minus 10 points.
      
    // method: PlayScreenGUI
    // purpose: constructor for the class
    public PlayScreenGUI() {
//           buttonSkip.setToolTipText("Click to skip to Color Game.");
//           add(buttonSkip);
 
        // Shows Info Frame when F1 is pressed
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_F1,0), "Info");
        getRootPane().getActionMap().put("Info", new AbstractAction(){ //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Info info = new Info();
            }
        });
        
        // Exits program when ESC key is pressed
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "Exit");
        getRootPane().getActionMap().put("Exit", new AbstractAction(){ //$NON-NLS-1$
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        

        chooseWord(); // initially choose a word randomly to start the game.
        currentScore = 100;
        loseCount = 0;
        currentAnswer = new char[chosenWord.length()];
        answer = new char[chosenWord.length()];
        //colorGame = new ColorGameGUI(finalScore);
        initComponents();
        buttonSkip.setToolTipText("Click to skip to Color Game.");
        displayDateTime();
        startGame();
        
        //all limbs will be default to setVisible as false until player guesses wrong    
        leftArm.setVisible(false);
        rightArm.setVisible(false);
        body.setVisible(false);
        head.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);   
    }
    
    // method: chooseWord
    // purpose: Randomly choose a word from WORD_BANK 
    public void chooseWord() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        chosenWord = WORD_BANK[randomIndex];
    }
    
    // method: getWordSize
    // purpose: returns the size of the chosen word.
    public int getWordSize() {
        return chosenWord.length();
    }
    
    // method: convertToArray
    // purpose: convert the chosen word into an array of characters.
    public void convertToArray() {
        for (int i = 0; i < getWordSize(); ++i) {
            answer[i] = chosenWord.charAt(i);
        }
    }
    
    // method: setInitialCurrentAnswer
    // purpose: initially set the characters of currentAnswer
    // as '_'.
    public void setInitialCurrentAnswer() {
        //currentAnswer = new char[chosenWord.length()];
        for (int i = 0; i < getWordSize(); ++i) {
            currentAnswer[i] = '_';
        }
    }
    
    // method: sizeFive
    // purpose: if the size of the chosen word is 5, then only
    // 5 labels are shown.
    public void sizeFive() {
            letter1.setVisible(true);
            letter2.setVisible(true);
            letter3.setVisible(true);
            letter4.setVisible(true);
            letter5.setVisible(true);
            letter6.setVisible(false);
            letter7.setVisible(false);
            letter8.setVisible(false);
    }
    
    // method: sizeEight
    // purpose: if the size of the chosen word is 8, then only
    // 8 labels are shown.
    public void sizeEight() {
            letter1.setVisible(true);
            letter2.setVisible(true);
            letter3.setVisible(true);
            letter4.setVisible(true);
            letter5.setVisible(true);
            letter6.setVisible(true);
            letter7.setVisible(true);
            letter8.setVisible(true);
    }
   
    // method: setAnswerSizeFive
    // purpose: set the corresponding label as each letter of currentAnswer.
    public void setAnswerSizeFive() {
        letter1.setText(currentAnswer[0] + "");
        letter2.setText(currentAnswer[1] + "");
        letter3.setText(currentAnswer[2] + "");
        letter4.setText(currentAnswer[3] + "");
        letter5.setText(currentAnswer[4] + "");
    } 
    
    // method: setAnswerSizeEight
    // purpose: set the corresponding label as each letter of currentAnswer. 
    public void setAnswerSizeEight() {
        letter1.setText(currentAnswer[0] + "");
        letter2.setText(currentAnswer[1] + "");
        letter3.setText(currentAnswer[2] + "");
        letter4.setText(currentAnswer[3] + "");
        letter5.setText(currentAnswer[4] + "");
        letter6.setText(currentAnswer[5] + "");
        letter7.setText(currentAnswer[6] + "");
        letter8.setText(currentAnswer[7] + "");
    } 
    
    // method: attempt
    // purpose: check if user's guess was correct. If yes, then turn '_' to a
    // correct letter and update guess as true. Otherwise, do nothing. 
    public void attempt(char letter) {
        for (int i = 0; i < getWordSize(); ++i) {
            if (answer[i] == letter) {
                currentAnswer[i] = answer[i];
                guess = true;
            }
        }
    }
    
    // method: setGuessFalse
    // purpose: set guess as false.
    public void setGuessFalse() {
        guess = false;
    }
        
    // method: startGame
    // purpose: start the game and determine the approriate number of labels
    // that are to be used.
    public void startGame() {
        convertToArray();
        setInitialCurrentAnswer();
        
        if (getWordSize() == 5) {
            sizeFive();
            setAnswerSizeFive();
        } else {
            sizeEight();
            setAnswerSizeEight();
        }
    }
    
    // method: gameCycle
    // purpose: this method is the main body of the game. It updates every
    // necessary variable's data and event, updating loseCount whenever the
    // user gets wrong, displaying hangman figure, keeping a track of the 
    // number of labels, displaying currentScore, and finally checking
    // the game should end. 
    public void gameCycle(char letter) {
        attempt(letter);
        
        if (!guess) {
            loseCount++;
        }
        
         displayHangman(loseCount);
         
         if (getWordSize() == 5) {
            setAnswerSizeFive();
        } else {     
            setAnswerSizeEight();
        }
         
        displayScore();
        checkEndGame();
    }
    
    // method: getFinalScore
    // purpose: return the final score 
    public int getFinalScore() {
        return finalScore;
    }
    
    // method: updateScore
    // purpose: update the value that is being displayed
    public int updateScore() {
        return finalScore = currentScore - loseCount * MINUS;
    }
    
    // method: displayScore
    // purpose: change score label's text as the real-time score.
    public void displayScore() {
        String scoreValue = Integer.toString(updateScore());
        score.setText(scoreValue);
    }
    
    // method: displayHangman
    // purpose: update hangman figure whenever the user gets wrong.
    public void displayHangman(int choice) {
        switch(choice) {
            case 1:
                head.setVisible(true);
                break;
            case 2:
                body.setVisible(true);
                break;
            case 3:
                leftArm.setVisible(true);
                break;
            case 4:
                rightArm.setVisible(true);
                break;
            case 5:
                leftLeg.setVisible(true);
                break;
            case 6:
                rightLeg.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    // method: checkAnswers
    // purpose: compare currentAnswer and Answer to see if the user guessed all
    // the letters correctly.
    public boolean checkAnswers() {
        boolean stop = true;
        for (int i = 0; i < getWordSize(); ++i) {
            if (currentAnswer[i] != answer[i])
                stop = false;
        }
        return stop;
    }
    
    // method: checkEndGame
    // purpose: check whether or not the user reached the end condition:
    // either the user guessed 6-times wrong or guessed the correct word.
    public void checkEndGame() {
        if (loseCount >= 6 || checkAnswers())
            startColor();
    }
    
    // method: startColor
    // purpose: change the visibility of the play screen as false and
    // show the Color Game Gui
    public void startColor() {
        ColorGameGUI colorGame = new ColorGameGUI(finalScore);
        this.setVisible(false);
        colorGame.setScore(getFinalScore());
        colorGame.setVisible(true);
    }
    
    // method: displayDateTime
    // purpose: display current time and date. Update each second.
    public void displayDateTime() {
       
        currentTime = new Thread() {
            public void run() {
                for(;;) {
                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date dateObject = new Date();
                    dateTime.setText(dateFormat.format(dateObject));
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        };
        currentTime.start(); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonG = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        buttonSkip = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        dateTime = new javax.swing.JLabel();
        leftArm = new javax.swing.JLabel();
        rightArm = new javax.swing.JLabel();
        rightLeg = new javax.swing.JLabel();
        leftLeg = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        stand = new javax.swing.JLabel();
        letter1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        letter8 = new javax.swing.JButton();
        letter7 = new javax.swing.JButton();
        letter6 = new javax.swing.JButton();
        letter5 = new javax.swing.JButton();
        letter4 = new javax.swing.JButton();
        letter3 = new javax.swing.JButton();
        letter2 = new javax.swing.JButton();
        score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        buttonA.setText("A");
        buttonA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAMouseClicked(evt);
            }
        });
        getContentPane().add(buttonA);
        buttonA.setBounds(10, 300, 46, 46);

        buttonB.setText("B");
        buttonB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBMouseClicked(evt);
            }
        });
        getContentPane().add(buttonB);
        buttonB.setBounds(55, 300, 46, 46);

        buttonC.setText("C");
        buttonC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCMouseClicked(evt);
            }
        });
        getContentPane().add(buttonC);
        buttonC.setBounds(100, 300, 46, 46);

        buttonD.setText("D");
        buttonD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDMouseClicked(evt);
            }
        });
        getContentPane().add(buttonD);
        buttonD.setBounds(145, 300, 46, 46);

        buttonE.setText("E");
        buttonE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEMouseClicked(evt);
            }
        });
        getContentPane().add(buttonE);
        buttonE.setBounds(190, 300, 46, 46);

        buttonF.setText("F");
        buttonF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFMouseClicked(evt);
            }
        });
        getContentPane().add(buttonF);
        buttonF.setBounds(235, 300, 46, 46);

        buttonG.setText("G");
        buttonG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGMouseClicked(evt);
            }
        });
        getContentPane().add(buttonG);
        buttonG.setBounds(280, 300, 46, 46);

        buttonH.setText("H");
        buttonH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHMouseClicked(evt);
            }
        });
        getContentPane().add(buttonH);
        buttonH.setBounds(325, 300, 46, 46);

        buttonI.setText("I");
        buttonI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonIMouseClicked(evt);
            }
        });
        getContentPane().add(buttonI);
        buttonI.setBounds(370, 300, 46, 46);

        buttonJ.setText("J");
        buttonJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonJMouseClicked(evt);
            }
        });
        getContentPane().add(buttonJ);
        buttonJ.setBounds(415, 300, 46, 46);

        buttonK.setText("K");
        buttonK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonKMouseClicked(evt);
            }
        });
        getContentPane().add(buttonK);
        buttonK.setBounds(460, 300, 46, 46);

        buttonL.setText("L");
        buttonL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLMouseClicked(evt);
            }
        });
        getContentPane().add(buttonL);
        buttonL.setBounds(505, 300, 46, 46);

        buttonM.setText("M");
        buttonM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMMouseClicked(evt);
            }
        });
        getContentPane().add(buttonM);
        buttonM.setBounds(550, 300, 46, 46);

        buttonN.setText("N");
        buttonN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNMouseClicked(evt);
            }
        });
        getContentPane().add(buttonN);
        buttonN.setBounds(10, 350, 46, 46);

        buttonO.setText("O");
        buttonO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOMouseClicked(evt);
            }
        });
        getContentPane().add(buttonO);
        buttonO.setBounds(55, 350, 46, 46);

        buttonP.setText("P");
        buttonP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPMouseClicked(evt);
            }
        });
        getContentPane().add(buttonP);
        buttonP.setBounds(100, 350, 46, 46);

        buttonQ.setText("Q");
        buttonQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonQMouseClicked(evt);
            }
        });
        getContentPane().add(buttonQ);
        buttonQ.setBounds(145, 350, 46, 46);

        buttonR.setText("R");
        buttonR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRMouseClicked(evt);
            }
        });
        getContentPane().add(buttonR);
        buttonR.setBounds(190, 350, 46, 46);

        buttonS.setText("S");
        buttonS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSMouseClicked(evt);
            }
        });
        getContentPane().add(buttonS);
        buttonS.setBounds(235, 350, 46, 46);

        buttonT.setText("T");
        buttonT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTMouseClicked(evt);
            }
        });
        getContentPane().add(buttonT);
        buttonT.setBounds(280, 350, 46, 46);

        buttonU.setText("U");
        buttonU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUMouseClicked(evt);
            }
        });
        getContentPane().add(buttonU);
        buttonU.setBounds(325, 350, 46, 46);

        buttonV.setText("V");
        buttonV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVMouseClicked(evt);
            }
        });
        getContentPane().add(buttonV);
        buttonV.setBounds(370, 350, 46, 46);

        buttonW.setText("W");
        buttonW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonWMouseClicked(evt);
            }
        });
        getContentPane().add(buttonW);
        buttonW.setBounds(415, 350, 46, 46);

        buttonX.setText("X");
        buttonX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonXMouseClicked(evt);
            }
        });
        getContentPane().add(buttonX);
        buttonX.setBounds(460, 350, 46, 46);

        buttonY.setText("Y");
        buttonY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonYMouseClicked(evt);
            }
        });
        getContentPane().add(buttonY);
        buttonY.setBounds(505, 350, 46, 46);

        buttonZ.setText("Z");
        buttonZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonZMouseClicked(evt);
            }
        });
        getContentPane().add(buttonZ);
        buttonZ.setBounds(550, 350, 46, 46);

        buttonSkip.setText("Skip");
        buttonSkip.setPreferredSize(new java.awt.Dimension(40, 20));
        buttonSkip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSkipMouseClicked(evt);
            }
        });
        buttonSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSkipActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSkip);
        buttonSkip.setBounds(10, 10, 75, 33);

        title.setText("HANGMAN");
        getContentPane().add(title);
        title.setBounds(430, 10, 90, 20);

        dateTime.setText("Date and Time");
        getContentPane().add(dateTime);
        dateTime.setBounds(430, 30, 150, 20);

        leftArm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leftarm.png"))); // NOI18N
        leftArm.setText("jLabel3");
        getContentPane().add(leftArm);
        leftArm.setBounds(150, 100, 30, 70);

        rightArm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rightarm.png"))); // NOI18N
        rightArm.setText("jLabel1");
        getContentPane().add(rightArm);
        rightArm.setBounds(150, 110, 50, 50);

        rightLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rightleg.png"))); // NOI18N
        rightLeg.setText("jLabel1");
        rightLeg.setPreferredSize(new java.awt.Dimension(90, 90));
        getContentPane().add(rightLeg);
        rightLeg.setBounds(150, 90, 40, 90);

        leftLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leftleg.png"))); // NOI18N
        leftLeg.setText("jLabel1");
        getContentPane().add(leftLeg);
        leftLeg.setBounds(150, 90, 40, 90);

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/torso.png"))); // NOI18N
        body.setText("jLabel3");
        getContentPane().add(body);
        body.setBounds(150, 110, 50, 50);

        head.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/head.png"))); // NOI18N
        head.setText("jLabel1");
        getContentPane().add(head);
        head.setBounds(150, 90, 50, 90);

        stand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stand.png"))); // NOI18N
        stand.setText("jLabel1");
        getContentPane().add(stand);
        stand.setBounds(0, 50, 200, 220);

        letter1.setEnabled(false);
        getContentPane().add(letter1);
        letter1.setBounds(210, 190, 46, 50);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.png"))); // NOI18N
        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(600, 400));
        background.setMinimumSize(new java.awt.Dimension(600, 400));
        background.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(background);
        background.setBounds(0, 0, 230, 290);

        letter8.setEnabled(false);
        getContentPane().add(letter8);
        letter8.setBounds(560, 190, 46, 50);

        letter7.setEnabled(false);
        getContentPane().add(letter7);
        letter7.setBounds(510, 190, 46, 50);

        letter6.setEnabled(false);
        getContentPane().add(letter6);
        letter6.setBounds(460, 190, 46, 50);

        letter5.setEnabled(false);
        getContentPane().add(letter5);
        letter5.setBounds(410, 190, 46, 50);

        letter4.setEnabled(false);
        getContentPane().add(letter4);
        letter4.setBounds(360, 190, 46, 50);

        letter3.setEnabled(false);
        getContentPane().add(letter3);
        letter3.setBounds(310, 190, 46, 50);

        letter2.setEnabled(false);
        getContentPane().add(letter2);
        letter2.setBounds(260, 190, 46, 50);

        score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score.setText("Score");
        score.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(score);
        score.setBounds(250, 20, 90, 40);

        setSize(new java.awt.Dimension(622, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method: button_MouseClicked
    // purpose: for all of the following, if a letter is clicked,
    //          it disables the button and sees if it is correct 
    private void buttonAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAMouseClicked
        buttonA.setEnabled(false);
        buttonA.setVisible(false);
        setGuessFalse();
        gameCycle('A');
    }//GEN-LAST:event_buttonAMouseClicked

    private void buttonBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBMouseClicked
        buttonB.setEnabled(false);
        buttonB.setVisible(false);
        setGuessFalse();
        gameCycle('B');
    }//GEN-LAST:event_buttonBMouseClicked

    private void buttonCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCMouseClicked
        buttonC.setEnabled(false);
        buttonC.setVisible(false);
        setGuessFalse();
        gameCycle('C');
    }//GEN-LAST:event_buttonCMouseClicked

    private void buttonDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDMouseClicked
        buttonD.setEnabled(false);
        buttonD.setVisible(false);
        setGuessFalse();
        gameCycle('D');
    }//GEN-LAST:event_buttonDMouseClicked

    private void buttonEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEMouseClicked
        buttonE.setEnabled(false);
        buttonE.setVisible(false);
        setGuessFalse();
        gameCycle('E');
    }//GEN-LAST:event_buttonEMouseClicked

    private void buttonFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFMouseClicked
        buttonF.setEnabled(false);
        buttonF.setVisible(false);
        setGuessFalse();
        gameCycle('F');
    }//GEN-LAST:event_buttonFMouseClicked

    private void buttonGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGMouseClicked
        buttonG.setEnabled(false);
        buttonG.setVisible(false);
        setGuessFalse();
        gameCycle('G');
    }//GEN-LAST:event_buttonGMouseClicked

    private void buttonHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHMouseClicked
        buttonH.setEnabled(false);
        buttonH.setVisible(false);
        setGuessFalse();
        gameCycle('H');
    }//GEN-LAST:event_buttonHMouseClicked

    private void buttonIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIMouseClicked
        buttonI.setEnabled(false);
        buttonI.setVisible(false);
        setGuessFalse();
        gameCycle('I');
    }//GEN-LAST:event_buttonIMouseClicked

    private void buttonJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJMouseClicked
        buttonJ.setEnabled(false);
        buttonJ.setVisible(false);
        setGuessFalse();
        gameCycle('J');
    }//GEN-LAST:event_buttonJMouseClicked

    private void buttonKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKMouseClicked
        buttonK.setEnabled(false);
        buttonK.setVisible(false);
        setGuessFalse();
        gameCycle('K');
    }//GEN-LAST:event_buttonKMouseClicked

    private void buttonLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLMouseClicked
        buttonL.setEnabled(false);
        buttonL.setVisible(false);
        setGuessFalse();
        gameCycle('L');
    }//GEN-LAST:event_buttonLMouseClicked

    private void buttonMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMMouseClicked
        buttonM.setEnabled(false);
        buttonM.setVisible(false);
        setGuessFalse();
        gameCycle('M');
    }//GEN-LAST:event_buttonMMouseClicked

    private void buttonNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNMouseClicked
        buttonN.setEnabled(false);
        buttonN.setVisible(false);
        setGuessFalse();
        gameCycle('N');
    }//GEN-LAST:event_buttonNMouseClicked

    private void buttonOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOMouseClicked
        buttonO.setEnabled(false);
        buttonO.setVisible(false);
        setGuessFalse();
        gameCycle('O');
    }//GEN-LAST:event_buttonOMouseClicked

    private void buttonPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPMouseClicked
        buttonP.setEnabled(false);
        buttonP.setVisible(false);
        setGuessFalse();
        gameCycle('P');
    }//GEN-LAST:event_buttonPMouseClicked

    private void buttonQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonQMouseClicked
        buttonQ.setEnabled(false);
        buttonQ.setVisible(false);
        setGuessFalse();
        gameCycle('Q');
    }//GEN-LAST:event_buttonQMouseClicked

    private void buttonRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRMouseClicked
        buttonR.setEnabled(false);
        buttonR.setVisible(false);
        setGuessFalse();
        gameCycle('R');
    }//GEN-LAST:event_buttonRMouseClicked

    private void buttonSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSMouseClicked
        buttonS.setEnabled(false);
        buttonS.setVisible(false);
        setGuessFalse();
        gameCycle('S');
    }//GEN-LAST:event_buttonSMouseClicked

    private void buttonTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTMouseClicked
        buttonT.setEnabled(false);
        buttonT.setVisible(false);
        setGuessFalse();
        gameCycle('T');
    }//GEN-LAST:event_buttonTMouseClicked

    private void buttonUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUMouseClicked
        buttonU.setEnabled(false);
        buttonU.setVisible(false);
        setGuessFalse();
        gameCycle('U');
    }//GEN-LAST:event_buttonUMouseClicked

    private void buttonVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVMouseClicked
        buttonV.setEnabled(false);
        buttonV.setVisible(false);
        setGuessFalse();
        gameCycle('V');
    }//GEN-LAST:event_buttonVMouseClicked

    private void buttonWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWMouseClicked
        buttonW.setEnabled(false);
        buttonW.setVisible(false);
        setGuessFalse();
        gameCycle('W');
    }//GEN-LAST:event_buttonWMouseClicked

    private void buttonXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXMouseClicked
        buttonX.setEnabled(false);
        buttonX.setVisible(false);
        setGuessFalse();
        gameCycle('X');
    }//GEN-LAST:event_buttonXMouseClicked

    private void buttonYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonYMouseClicked
        buttonY.setEnabled(false);
        buttonY.setVisible(false);
        setGuessFalse();
        gameCycle('Y');
    }//GEN-LAST:event_buttonYMouseClicked

    private void buttonZMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonZMouseClicked
        buttonZ.setEnabled(false);
        buttonZ.setVisible(false);
        setGuessFalse();
        gameCycle('Z');
    }//GEN-LAST:event_buttonZMouseClicked

    // method: buttonSkipMouseClicked
    // purpose: sets the final score to 0 and ends the game
    private void buttonSkipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSkipMouseClicked
        finalScore = 0;
        startColor();
    }//GEN-LAST:event_buttonSkipMouseClicked

    private void buttonSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSkipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSkipActionPerformed
 
    // method: main
    // purpose: runs the current screen on its own
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayScreenGUI().setVisible(true);
            }
            
        });
        
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel body;
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JButton buttonD;
    private javax.swing.JButton buttonE;
    private javax.swing.JButton buttonF;
    private javax.swing.JButton buttonG;
    private javax.swing.JButton buttonH;
    private javax.swing.JButton buttonI;
    private javax.swing.JButton buttonJ;
    private javax.swing.JButton buttonK;
    private javax.swing.JButton buttonL;
    private javax.swing.JButton buttonM;
    private javax.swing.JButton buttonN;
    private javax.swing.JButton buttonO;
    private javax.swing.JButton buttonP;
    private javax.swing.JButton buttonQ;
    private javax.swing.JButton buttonR;
    private javax.swing.JButton buttonS;
    private javax.swing.JButton buttonSkip;
    private javax.swing.JButton buttonT;
    private javax.swing.JButton buttonU;
    private javax.swing.JButton buttonV;
    private javax.swing.JButton buttonW;
    private javax.swing.JButton buttonX;
    private javax.swing.JButton buttonY;
    private javax.swing.JButton buttonZ;
    private javax.swing.JLabel dateTime;
    private javax.swing.JLabel head;
    private javax.swing.JLabel leftArm;
    private javax.swing.JLabel leftLeg;
    private javax.swing.JButton letter1;
    private javax.swing.JButton letter2;
    private javax.swing.JButton letter3;
    private javax.swing.JButton letter4;
    private javax.swing.JButton letter5;
    private javax.swing.JButton letter6;
    private javax.swing.JButton letter7;
    private javax.swing.JButton letter8;
    private javax.swing.JLabel rightArm;
    private javax.swing.JLabel rightLeg;
    private javax.swing.JLabel score;
    private javax.swing.JLabel stand;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
