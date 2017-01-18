package gui;

/***************************************************************
* file: MenuGUI.java
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
* purpose: This is the main menu. It has three buttons. Play button takes
* the user to play a hangman game. High Score button shows top 5 scores of the
* game. Credits button shows the creators of the program.
*
****************************************************************/


public class MenuGUI extends javax.swing.JFrame {

    // method: MenuGUI
    // purpose: constructor for the class
    public MenuGUI() {
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        highScoreButton = new javax.swing.JButton();
        creditsButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        playButton.setBackground(new java.awt.Color(255, 255, 153));
        playButton.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        playButton.setText("Play");
        playButton.setPreferredSize(null);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton);
        playButton.setBounds(380, 190, 200, 45);

        highScoreButton.setBackground(new java.awt.Color(255, 255, 153));
        highScoreButton.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        highScoreButton.setText("High Scores");
        highScoreButton.setPreferredSize(null);
        highScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoreButtonActionPerformed(evt);
            }
        });
        getContentPane().add(highScoreButton);
        highScoreButton.setBounds(380, 250, 200, 45);

        creditsButton.setBackground(new java.awt.Color(255, 255, 153));
        creditsButton.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        creditsButton.setText("Credits");
        creditsButton.setPreferredSize(null);
        creditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(creditsButton);
        creditsButton.setBounds(380, 310, 200, 45);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/duck_resized.jpg"))); // NOI18N
        getContentPane().add(imageLabel);
        imageLabel.setBounds(30, 160, 300, 210);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black_back.png"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 600, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // method: playButtonActionPerformed
    // purpose: disables the current screen and enables the Play Screen
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        this.setVisible(false);
        new PlayScreenGUI().setVisible(true);
        
    }//GEN-LAST:event_playButtonActionPerformed

    // method: highScoreButtonActionPerformed
    // purpose: disables the current scren and enables the High Score Screen
    private void highScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoreButtonActionPerformed
        this.setVisible(false);
        new HighScoreGUI().setVisible(true);
    }//GEN-LAST:event_highScoreButtonActionPerformed

    // method: creditsButtonActionsPerformed
    // purpose: disables the current screen and enables the Credit Screen
    private void creditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsButtonActionPerformed
        this.setVisible(false);
        new CreditsGUI().setVisible(true);
    }//GEN-LAST:event_creditsButtonActionPerformed

    // method: main
    // purpose: runs the current screen on its own
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton creditsButton;
    private javax.swing.JButton highScoreButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
