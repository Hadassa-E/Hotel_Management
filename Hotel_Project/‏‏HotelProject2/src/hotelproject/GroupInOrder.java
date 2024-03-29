/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelproject;

import Classes.GroupOrder;
import Classes.TypeRoom;
import clientserverproject.Client;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author comp2
 */
public class GroupInOrder extends javax.swing.JFrame {

    private Client client;
    private GroupOrder group;
    
    
    public void addListenerToWindowClosing(WindowAdapter wa)
    {
        this.addWindowListener(wa); 
    }

    /**
     * Creates new form GruopInOrder
     */
    public GroupInOrder(Client client, GroupOrder go) {
        this.getContentPane().setBackground(Color.WHITE);
        this.client = client;
        group = go;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        connectingDoor = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        numAdultsBeds = new javax.swing.JSpinner();
        numChildrenBeds = new javax.swing.JSpinner();
        typeRoom = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("הזמנה לקבוצה");

        jLabel2.setText("מספר מיטות מבוגרים");

        jLabel3.setText("מספר מיטות ילדים");

        jLabel5.setText("סוג חדר");

        connectingDoor.setText("האם יש עדיפות לחדר עם דלת מקושרת?");
        connectingDoor.setAlignmentX(1.0F);
        connectingDoor.setName(""); // NOI18N
        connectingDoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectingDoorActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(242, 241, 215));
        jButton1.setLabel("הוספה");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        numAdultsBeds.setName(""); // NOI18N

        numChildrenBeds.setName(""); // NOI18N

        typeRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "חדר סטנדרטי", "חדר דלוקס", "סוויטה", "חדר נגיש" }));
        typeRoom.setName(""); // NOI18N
        typeRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeRoomActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelproject/hotel.png"))); // NOI18N
        jLabel6.setIconTextGap(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(typeRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(numAdultsBeds, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addComponent(numChildrenBeds, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(connectingDoor)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numAdultsBeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numChildrenBeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(typeRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(connectingDoor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if((Integer.parseInt(numAdultsBeds.getValue().toString())<0)
        ||(Integer.parseInt(numChildrenBeds.getValue().toString())<0)
        ||Integer.parseInt(numChildrenBeds.getValue().toString())
        +Integer.parseInt(numAdultsBeds.getValue().toString())==0)//אם הקלט איננו תקין
    JOptionPane.showMessageDialog(null, "הכנסת כמות מיטות לא חוקית, אנא נסה שנית"); 
else{
    if(connectingDoor.isSelected()&&Integer.parseInt(numChildrenBeds.getValue().toString())
        +Integer.parseInt(numAdultsBeds.getValue().toString())>10)
            JOptionPane.showMessageDialog(null, "אין אפשרות לבקשת דלתות מקושרות אם כמות האנשים בקבוצה גדולה מ-10"); 
    else{  
    group.setNumAdultsBeds(Integer.parseInt(numAdultsBeds.getValue().toString()));
        group.setNumChildrenBeds(Integer.parseInt(numChildrenBeds.getValue().toString()));
        switch(typeRoom.getSelectedItem().toString())
        {
            case "חדר סטנדרטי":
                group.setTypeRoom(TypeRoom.STANDART_ROOM);
                break;
           case "חדר דלוקס":
                group.setTypeRoom(TypeRoom.DELUX_ROOM);
                break;
           case "סוויטה":
                group.setTypeRoom(TypeRoom.SUITE_ROOM);
                break;
           case "חדר נגיש":
                group.setTypeRoom(TypeRoom.ACCESSIBLE_ROOM);
                break;
        }
        group.setConnectingDoor(connectingDoor.isSelected());
        this.dispose();  
}
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void typeRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeRoomActionPerformed

    private void connectingDoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectingDoorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectingDoorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox connectingDoor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner numAdultsBeds;
    private javax.swing.JSpinner numChildrenBeds;
    private javax.swing.JComboBox<String> typeRoom;
    // End of variables declaration//GEN-END:variables
}

