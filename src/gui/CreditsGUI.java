package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import other.Info;

/***************************************************************
* file: CreditsGUI.java
* author: Hagop Bowazoglanian
*         John Vincent Canalita
*         Eugene Lee
*         Seungyun Lee
*         Dylan Nguyen
* 
* Class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1.1
* date last modified: 1/16/2017
*
* purpose: Creates the Credits page for the Hangman game, showing
*          the names and bID of all the members of the team
*
****************************************************************/


public class CreditsGUI extends javax.swing.JFrame {
    
    // method: CreditsGUI
    // purpose: initializes the GUI for the Credits page
    public CreditsGUI() {
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
        initComponents();
        
        // Tooltip instantiation
        creditsBackButton.setToolTipText("Click to go back to Main Menu.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creditsTitle = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        creditsBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        creditsTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        creditsTitle.setText("CREDITS");
        creditsTitle.setPreferredSize(new java.awt.Dimension(200, 100));
        getContentPane().add(creditsTitle);
        creditsTitle.setBounds(235, 50, 110, 30);

        name1.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        name1.setText("John Vincent Canalita, 010440703");
        getContentPane().add(name1);
        name1.setBounds(195, 130, 210, 19);

        name2.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        name2.setText("Eugene Lee, 010013757");
        getContentPane().add(name2);
        name2.setBounds(225, 160, 150, 19);

        name3.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        name3.setText("Seungyun Lee, 010710830");
        getContentPane().add(name3);
        name3.setBounds(220, 190, 160, 19);

        name4.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        name4.setText("Hagop Bozawglanian, 009320428");
        name4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        name4.setPreferredSize(new java.awt.Dimension(160, 20));
        getContentPane().add(name4);
        name4.setBounds(195, 100, 210, 20);

        name5.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        name5.setText("Dylan Nguyen, 010135203");
        getContentPane().add(name5);
        name5.setBounds(220, 220, 160, 19);

        creditsBackButton.setText("Back");
        creditsBackButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        creditsBackButton.setPreferredSize(new java.awt.Dimension(75, 33));
        creditsBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsBackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(creditsBackButton);
        creditsBackButton.setBounds(5, 335, 75, 33);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // method: creditsBackButtonActionPerformed
    // purpose: disables the current screen and enables the Menu screen
    private void creditsBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsBackButtonActionPerformed
       this.setVisible(false); 
        new MenuGUI().setVisible(true); 
           
     
    
       
    }//GEN-LAST:event_creditsBackButtonActionPerformed

    // method: main
    // purpose: runs the current GUI if ran on its own
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreditsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditsBackButton;
    private javax.swing.JLabel creditsTitle;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    // End of variables declaration//GEN-END:variables
}
