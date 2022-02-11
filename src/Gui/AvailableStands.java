/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.TicketDetails.ticket;
import Objects.eventStringObject;
import libraryFunctions.databaseOrders;

/**
 *
 * @author PC
 */
public class AvailableStands extends javax.swing.JFrame {

    public static eventStringObject stand;
    public static eventStringObject tempStand;

    public void getEvent() {
        tempStand = TicketDetails.returnEvent();
    }

    public static eventStringObject returnEvent() {
        return ticket;
    }

    public AvailableStands() {
        initComponents();
        getEvent();
        hideButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        standTwo = new javax.swing.JButton();
        standOne = new javax.swing.JButton();
        standFive = new javax.swing.JButton();
        standSix = new javax.swing.JButton();
        standSeven = new javax.swing.JButton();
        standFour = new javax.swing.JToggleButton();
        standThree = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ticketSelectedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Select a Stand");

        standTwo.setText("2");
        standTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standTwoActionPerformed(evt);
            }
        });

        standOne.setText("1");
        standOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standOneActionPerformed(evt);
            }
        });

        standFive.setText("5");
        standFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standFiveActionPerformed(evt);
            }
        });

        standSix.setText("6");
        standSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standSixActionPerformed(evt);
            }
        });

        standSeven.setText("7");
        standSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standSevenActionPerformed(evt);
            }
        });

        standFour.setText("4");
        standFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standFourActionPerformed(evt);
            }
        });

        standThree.setText("3");
        standThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standThreeActionPerformed(evt);
            }
        });

        jButton3.setText("back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ticketSelectedLabel.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(standOne, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(standThree)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(standFour)
                                        .addGap(89, 89, 89)
                                        .addComponent(standFive))
                                    .addComponent(standSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(standSix)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(ticketSelectedLabel)))
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ticketSelectedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(standOne, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(standTwo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(standFive, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(standSix, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(standFour, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(standThree, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(standSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void standOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standOneActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standOneActionPerformed

    private void standThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standThreeActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standThreeActionPerformed

    private void standTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standTwoActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standTwoActionPerformed

    private void standFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standFourActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_standFourActionPerformed

    private void standFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standFiveActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standFiveActionPerformed

    private void standSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standSixActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standSixActionPerformed

    private void standSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standSevenActionPerformed
        String standName = "4";
        eventStringObject eventEntered = new eventStringObject(tempStand.getEvent(), tempStand.getType(), standName);
        ticket = eventEntered;
        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_standSevenActionPerformed
    public void toSeats() {

        availableSeats seats = new availableSeats();

        seats.setVisible(true);
        this.dispose();
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TicketDetails ticket = new TicketDetails();

        ticket.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void getTicketType() {

    }

    public void hideButtons() {
        if (ticket.getType().equals("vip")) {
            standOne.setVisible(true);
            standTwo.setVisible(false);
            standThree.setVisible(false);
            standFour.setVisible(false);
            standFive.setVisible(false);
            standSix.setVisible(false);
            standSeven.setVisible(false);

        } else if (ticket.getType().equals("child")) {
            standOne.setVisible(false);
            standTwo.setVisible(false);
            standThree.setVisible(true);
            standFour.setVisible(true);
            standFive.setVisible(false);
            standSix.setVisible(false);
            standSeven.setVisible(false);
        } else if (ticket.getType().equals("disabled")) {
            standOne.setVisible(false);
            standTwo.setVisible(true);
            standThree.setVisible(true);
            standFour.setVisible(true);
            standFive.setVisible(false);
            standSix.setVisible(false);
            standSeven.setVisible(false);
        } else if (ticket.getType().equals("standard")) {
            standOne.setVisible(false);
            standTwo.setVisible(true);
            standThree.setVisible(false);
            standFour.setVisible(false);
            standFive.setVisible(true);
            standSix.setVisible(true);
            standSeven.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(AvailableStands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvailableStands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvailableStands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvailableStands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvailableStands().setVisible(true);
                // AvailableStands standPage = new AvailableStands();
                // standPage.hideButtons();
                // standPage.repaint();
                // standPage.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton standFive;
    private javax.swing.JToggleButton standFour;
    private javax.swing.JButton standOne;
    private javax.swing.JButton standSeven;
    private javax.swing.JButton standSix;
    private javax.swing.JButton standThree;
    private javax.swing.JButton standTwo;
    public static javax.swing.JLabel ticketSelectedLabel;
    // End of variables declaration//GEN-END:variables
}
