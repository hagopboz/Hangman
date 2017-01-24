/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ELEE
 */
public class ColorGameGUI extends javax.swing.JFrame {

    private final String [] COLORS = {"GREEN", "RED", 
    "BLUE", "YELLOW", "PURPLE"};
    static String chosenWord;
    static int finalScore;
    private EndScreen endScreen;
    private PlayScreenGUI playScreen;
    
    Color[] color;
    Color chosenColor;
    /**
     * Creates new form ColorGameGUI
     */
    public ColorGameGUI(int finalScore) {
        
        this.finalScore = finalScore;
        endScreen = new EndScreen(finalScore);
        displayDateTimeColor();
        initComponents();
        setWord();
        setColor();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        title.setText("Color Game");
        getContentPane().add(title);
        title.setBounds(430, 10, 90, 20);

        redBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redSplat.png"))); // NOI18N
        redBtn.setBorder(null);
        redBtn.setBorderPainted(false);
        redBtn.setContentAreaFilled(false);
        redBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        getContentPane().add(redBtn);
        redBtn.setBounds(20, 120, 130, 100);

        purpleBtn.setBackground(null);
        purpleBtn.setForeground(null);
        purpleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purpleSplat.png"))); // NOI18N
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
        purpleBtn.setBounds(210, 30, 100, 100);

        greenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/greenSplat.png"))); // NOI18N
        greenBtn.setBorder(null);
        greenBtn.setBorderPainted(false);
        greenBtn.setContentAreaFilled(false);
        greenBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        getContentPane().add(greenBtn);
        greenBtn.setBounds(120, 250, 130, 100);

        yellowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yellowSplat.png"))); // NOI18N
        yellowBtn.setBorder(null);
        yellowBtn.setBorderPainted(false);
        yellowBtn.setContentAreaFilled(false);
        yellowBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackSplat.png"))); // NOI18N
        getContentPane().add(yellowBtn);
        yellowBtn.setBounds(340, 240, 130, 100);

        dateTime.setText("Date and Time");
        getContentPane().add(dateTime);
        dateTime.setBounds(430, 30, 140, 20);

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
        blueBtn.setBounds(410, 80, 130, 100);

        colorWord.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        colorWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorWord.setText("Color");
        colorWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(colorWord);
        colorWord.setBounds(170, 160, 230, 50);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void purpleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purpleBtnActionPerformed

    private void blueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueBtnActionPerformed

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
    
    // method: getFinalScore
    // purpose: return the final score 
    public int getFinalScore() {
        return finalScore;
    }
        
    // method: chooseWord
    // purpose: Randomly choose a word from WORD_BANK 
    public String chooseWord() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        return chosenWord = COLORS[randomIndex];
    }
    
    public void setWord() {
        colorWord.setText(chooseWord());
    }
    
    public void setColor() {
        color = new Color [5];
        color[0] = new Color(255, 0, 51); //red
        color[1] = new Color(51, 51, 255); //blue
        color[2] = new Color(0, 255, 0); //green
        color[3] = new Color(255, 255, 0); //yellow
        color[4] = new Color(204, 0, 204); //purple
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(5);
        chosenColor = color[randomIndex];
        colorWord.setForeground(chosenColor);
    }
    
    // method: endGame
    // purpose: change the visibility of the play screen as false and
    // show the end screen
    public void endGame() {
        this.setVisible(false);
        endScreen.setScore(getFinalScore());
        endScreen.setVisible(true);
    }
    
    public void setScore(int finalScore) {
        String displayScore = Integer.toString(finalScore);
        //scoreLabel.setText(displayScore);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueBtn;
    private javax.swing.JLabel colorWord;
    private javax.swing.JLabel dateTime;
    private javax.swing.JButton greenBtn;
    private javax.swing.JButton purpleBtn;
    private javax.swing.JButton redBtn;
    private javax.swing.JLabel title;
    private javax.swing.JButton yellowBtn;
    // End of variables declaration//GEN-END:variables
}
