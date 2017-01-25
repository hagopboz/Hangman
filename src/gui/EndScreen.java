/***************************************************************
* file: EndScreen.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.0
* date last modified: 1/16/2017
*
* purpose: Creates the End screen page for the Hangman game,
*          showing the final score of the player when the game
*          ends
*
****************************************************************/
package gui;

public class EndScreen extends javax.swing.JFrame {

    private int finalScore;
    private PlayScreenGUI playScreen;
    
    // method: EndScreen
    // purpose: Constructor of the EndScreen class
    public EndScreen(int finalScore) {
        
        this.finalScore = finalScore;
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

        scoreLabel = new javax.swing.JLabel();
        scoreValue = new javax.swing.JLabel();
        buttonEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        scoreLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Score");
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(260, 60, 80, 50);

        scoreValue.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        scoreValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreValue.setText("Actual Score");
        getContentPane().add(scoreValue);
        scoreValue.setBounds(190, 150, 220, 50);

        buttonEnd.setText("End");
        buttonEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEndMouseClicked(evt);
            }
        });
        getContentPane().add(buttonEnd);
        buttonEnd.setBounds(20, 350, 80, 30);

        setSize(new java.awt.Dimension(616, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method: buttonEndMouseClicked
    // purpose: disables current screen and enables the Menu screen
    private void buttonEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEndMouseClicked
        this.setVisible(false); 
        new MenuGUI().setVisible(true); 
    }//GEN-LAST:event_buttonEndMouseClicked

    // method: setScore
    // purpose: sets the player's final score and displays it
    public void setScore(int finalScore) {
        String displayScore = Integer.toString(finalScore);
        scoreValue.setText(displayScore);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnd;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreValue;
    // End of variables declaration//GEN-END:variables
}
