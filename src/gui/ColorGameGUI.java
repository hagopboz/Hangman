/***************************************************************
* file: ColorGameGUI.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/25/2017
*
* purpose: Color Game graphical user interface.
*
****************************************************************/
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import other.Info;

public class ColorGameGUI extends javax.swing.JFrame {

    private final String [] COLORS = {"GREEN", "RED", 
    "BLUE", "YELLOW", "PURPLE"}; //possible words that can be printed.
    static String chosenWord; //Current word being displayed.
    static int finalScore;//Score of the total game.
    static int scoreCount;//Score of color game.
    // private EndScreen endScreen; //Screen to move on to.
    private HangmanGUI playScreen;//Screen it came from.
    private int count = 0;//Count to see how many turns have passed.
    Color[] color;//Creates an array of colors for the color of the word.
    Color chosenColor;//Color of current word being displayed.
    private boolean[][] possiblePositions; //possible positions that buttons can be placed.
    
    /**
     * Creates new form ColorGameGUI
     */
    public ColorGameGUI(int finalScore) {
        
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
        
        possiblePositions = new boolean[3][5];
        this.finalScore = finalScore;
        // endScreen = new EndScreen(finalScore);
        displayDateTimeColor();
        initializePositions();
        initComponents();
        blueBtn.setToolTipText("Choose blue as your answer.");
        redBtn.setToolTipText("Choose red as your answer.");
        greenBtn.setToolTipText("Choose green as your answer.");
        purpleBtn.setToolTipText("Choose purple as your answer.");
        yellowBtn.setToolTipText("Choose yellow as your answer.");
        placeButtons();
        setWord();
        setColor();
    }
    
    /**
     * method: initializePositoins
     * purpose: initialize every possible position to false
     */
    public void initializePositions() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j){
                possiblePositions[i][j] = false;
            }
        }
    }
    
     /**
     * method: placeButtons
     * purpose: place buttons randomly
     */
    public void placeButtons(){
        Random rand = new Random();
        boolean success = false;
        int xRand;
        int yRand;
        int x;
        int y;
        while(!success){
            xRand = rand.nextInt(5);
            yRand = rand.nextInt(3);
            if (!possiblePositions[yRand][xRand]) {
                possiblePositions[yRand][xRand] = true;
                y = yRand * 100 + 60;
                x = xRand *100 + 50;           
                blueBtn.setLocation(x, y);
                success = true;
            }         
        }
        success = false;
     
        while(!success){
            xRand = rand.nextInt(5);
            yRand = rand.nextInt(3);
            if (!possiblePositions[yRand][xRand]) {
                possiblePositions[yRand][xRand] = true;
                y = yRand * 100 + 60;
                x = xRand *100 + 50;             
                greenBtn.setLocation(x, y);
                success = true;
            }        
        }
        success = false;
     
        while(!success){
            xRand = rand.nextInt(5);
            yRand = rand.nextInt(3);
            if (!possiblePositions[yRand][xRand]) {
                possiblePositions[yRand][xRand] = true;
                y = yRand * 100 + 60;
                x = xRand *100 + 50;       
                purpleBtn.setLocation(x, y);
                success = true;
            }           
        }
        success = false;
        
        while(!success){
            xRand = rand.nextInt(5);
            yRand = rand.nextInt(3);
            if (!possiblePositions[yRand][xRand]) {
                possiblePositions[yRand][xRand] = true;
                y = yRand * 100 + 60;
                x = xRand *100 + 50;         
                redBtn.setLocation(x, y);
                success = true;
            }            
        }
        success = false;
        
        while(!success){
            xRand = rand.nextInt(5);
            yRand = rand.nextInt(3);
            if (!possiblePositions[yRand][xRand]) {
                possiblePositions[yRand][xRand] = true;
                y = yRand * 100 + 60;
                x = xRand *100 + 50;
                yellowBtn.setLocation(x, y);
                success = true;
            }            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        redBtn = new javax.swing.JButton();
        purpleBtn = new javax.swing.JButton();
        greenBtn = new javax.swing.JButton();
        yellowBtn = new javax.swing.JButton();
        dateTime = new javax.swing.JLabel();
        blueBtn = new javax.swing.JButton();
        colorWord = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        title.setText("Color Game");
        getContentPane().add(title);
        title.setBounds(430, 10, 90, 14);

        redBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redSplat.png"))); // NOI18N
        redBtn.setBorder(null);
        redBtn.setBorderPainted(false);
        redBtn.setContentAreaFilled(false);
        redBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        redBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redBtnActionPerformed(evt);
            }
        });
        getContentPane().add(redBtn);
        redBtn.setBounds(50, 90, 100, 100);
        redBtn.getAccessibleContext().setAccessibleName("RED");

        purpleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purpleSplat.png"))); // NOI18N
        purpleBtn.setToolTipText("");
        purpleBtn.setBorder(null);
        purpleBtn.setBorderPainted(false);
        purpleBtn.setContentAreaFilled(false);
        purpleBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        purpleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleBtnActionPerformed(evt);
            }
        });
        getContentPane().add(purpleBtn);
        purpleBtn.setBounds(450, 90, 100, 100);
        purpleBtn.getAccessibleContext().setAccessibleName("PURPLE");

        greenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/greenSplat.png"))); // NOI18N
        greenBtn.setBorder(null);
        greenBtn.setBorderPainted(false);
        greenBtn.setContentAreaFilled(false);
        greenBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        greenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenBtnActionPerformed(evt);
            }
        });
        getContentPane().add(greenBtn);
        greenBtn.setBounds(250, 90, 100, 100);
        greenBtn.getAccessibleContext().setAccessibleName("GREEN");

        yellowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yellowSplat.png"))); // NOI18N
        yellowBtn.setBorder(null);
        yellowBtn.setBorderPainted(false);
        yellowBtn.setContentAreaFilled(false);
        yellowBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        yellowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowBtnActionPerformed(evt);
            }
        });
        getContentPane().add(yellowBtn);
        yellowBtn.setBounds(350, 90, 100, 100);
        yellowBtn.getAccessibleContext().setAccessibleName("YELLOW");

        dateTime.setText("Date and Time");
        getContentPane().add(dateTime);
        dateTime.setBounds(430, 30, 140, 14);

        blueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blueSplat.png"))); // NOI18N
        blueBtn.setBorder(null);
        blueBtn.setBorderPainted(false);
        blueBtn.setContentAreaFilled(false);
        blueBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        blueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blueBtn);
        blueBtn.setBounds(150, 90, 100, 100);
        blueBtn.getAccessibleContext().setAccessibleName("BLUE");

        colorWord.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        colorWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorWord.setText("Color");
        colorWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(colorWord);
        colorWord.setBounds(180, 10, 230, 50);

        scoreLabel.setEnabled(false);
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(430, 50, 0, 0);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method: colorBtnActionPerformed
    // purpose: for all of the following, if a button is cliked
    // it sends the corresponding color to the game cycle and start
    // the game cycle
    private void purpleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleBtnActionPerformed
        gameCycle(Color.MAGENTA);
    }//GEN-LAST:event_purpleBtnActionPerformed

    private void blueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueBtnActionPerformed
        gameCycle(Color.BLUE);
    }//GEN-LAST:event_blueBtnActionPerformed

    private void redBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redBtnActionPerformed
        gameCycle(Color.RED);
    }//GEN-LAST:event_redBtnActionPerformed

    private void greenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenBtnActionPerformed
        gameCycle(Color.GREEN);
    }//GEN-LAST:event_greenBtnActionPerformed

    private void yellowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowBtnActionPerformed
        gameCycle(Color.YELLOW);
    }//GEN-LAST:event_yellowBtnActionPerformed
 
    // method: getFinalScore
    // purpose: return the final score 
    public int getFinalScore() {
        return finalScore + scoreCount;
    }
        
    // method: chooseWord
    // purpose: Randomly choose a word from WORD_BANK 
    public String chooseWord() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        return chosenWord = COLORS[randomIndex];
    }
    
    // method: setWord
    // purpose: Changes the label to the new word generated.
    public void setWord() {
        colorWord.setText(chooseWord());
    }
    
    // method: setColor
    // purpose: Sets the colors in the array, randomly selects one, and changes 
    // forground of the Color word to the color generated.
    public void setColor() {
        color = new Color [5];
        color[0] = Color.RED; //red
        color[1] = Color.BLUE; //blue
        color[2] = Color.GREEN; //green
        color[3] = Color.YELLOW; //yellow
        color[4] = Color.MAGENTA; //purple
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        chosenColor = color[randomIndex];
        colorWord.setForeground(chosenColor);
    }
    
    // method: endGame
    // purpose: change the visibility of the play screen as false and
    // show the end screen
    public void endGame() {
        SudokuGUI sudoku = new SudokuGUI(getFinalScore());
        this.setVisible(false);
        sudoku.setScore(getFinalScore()); // changed to getFinalScore() instead of finalScore to properly pass argument
        sudoku.setVisible(true);
        scoreCount = 0;
    }
    
    // method: setScore
    // purpose: Sets the score in the JLabel
    public void setScore(int finalScore) {
        String displayScore = Integer.toString(finalScore);
        scoreLabel.setText(displayScore);
    }
    
    // method: gameCycle
    // purpose: This is the game engine that takes the color word and the color
    // and it checks if the user's guess is correct and changes the word and 
    // color while adding to the score.
    public void gameCycle(Color color) {
        finalScore = Integer.parseInt(scoreLabel.getText());
        if (color == chosenColor){
            scoreCount = scoreCount + 100;
            setWord();
            setColor();
            //setScore(finalScore);
            count = count+1;
        } else {
            setWord();
            setColor();
            //setScore(finalScore);
            count = count+1;
        }
        if (count == 5) {
            endGame();
        }
    }
    
    // method: displayDateTime
    // purpose: display current time and date. Update each second.
    public void displayDateTimeColor() {
        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date();
                String time = timeFormat.format(date);
                dateTime.setText(dateFormat.format(date));
            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorGameGUI(finalScore).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueBtn;
    private javax.swing.JLabel colorWord;
    private javax.swing.JLabel dateTime;
    private javax.swing.JButton greenBtn;
    private javax.swing.JButton purpleBtn;
    private javax.swing.JButton redBtn;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel title;
    private javax.swing.JButton yellowBtn;
    // End of variables declaration//GEN-END:variables
}
