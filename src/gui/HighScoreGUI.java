package gui;

/***************************************************************
* file: HighScoreGUI.java
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
* purpose: Creates the High Score GUI for the Hangman game,
*          showing the high scores of the game with its player 
*
****************************************************************/
import highscore.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import other.Info;

public class HighScoreGUI extends javax.swing.JFrame {
    
    static String scoreList;
    // method: HighScoreGUI
    // purpose: constructor for the class
    public HighScoreGUI(String scoreList) {
        
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
        this.scoreList = scoreList;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        highscoreTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        title.setText("HIGHSCORES");
        title.setPreferredSize(new java.awt.Dimension(170, 35));
        getContentPane().add(title);
        title.setBounds(215, 50, 170, 35);

        backButton.setText("Back");
        backButton.setPreferredSize(new java.awt.Dimension(75, 33));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(3, 335, 75, 33);

        highscoreTextArea.setBackground(new java.awt.Color(238, 238, 238));
        highscoreTextArea.setColumns(20);
        highscoreTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        highscoreTextArea.setRows(5);
        highscoreTextArea.setEnabled(false);
        getContentPane().add(highscoreTextArea);
        highscoreTextArea.setBounds(180, 100, 240, 220);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method: backButtonActionPerformed
    // purpose: disables the current screen and enables the menu screen
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        new MenuGUI().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    // method: main
    // purpose: runs the current screen on its own
    public static void main(String args[]) {
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScoreGUI(scoreList).setVisible(true);
            }
        });
        
        
    }
    // method: printList
    //purpose: prints the scoreList (toString Arraylist of highscores)
    //         string to textArea
    public void printList() {
        highscoreTextArea.setText(scoreList);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea highscoreTextArea;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
