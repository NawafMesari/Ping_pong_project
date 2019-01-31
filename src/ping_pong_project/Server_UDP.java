/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping_pong_project;

import java.awt.Font;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UsEr
 */
public class Server_UDP extends javax.swing.JFrame {

//    
//    public static LinkedList <String> IP = new LinkedList<String>();
//    public static LinkedList <String> Port = new LinkedList<String>();
    public static Thread t1;
    public static Multi3 m1;

    public static DefaultTableModel model2 = new DefaultTableModel();

    // this for t1 because if he do not clicke the start then he clicke Back t1 will have null pointer exception
    public static boolean isStartBtnClicked = false;
    //this for ,if he Enter the port number first time and click start and click start again without change the port number he will tell him that port 
    // is already create 
    public static boolean isStarBtntClickFirstTime = true;
    //this  variable to save the Port number and check if he click the start again without change the port number he will tell him that port is already create 
    // this variable with the boolean variable in above help me to detected if the user he not change the port and click start again 
    public static String PortNumber = "";

    public Server_UDP() throws UnknownHostException {
        initComponents();

        InetAddress ia = InetAddress.getLocalHost();
        String IP = ia.getHostAddress().toString();

        IPAdd.setText("" + IP);

        Table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 12));

        model2 = (DefaultTableModel) Table.getModel();

    }

    //*************************************************************************
    public String getServer() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                    // System.out.println(iface.getDisplayName() + " " + ip);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return ip;
    }

    //***********************************************************************************************
    public void deleteOldDateOnJTable() {

        DefaultTableModel model2 = (DefaultTableModel) Table.getModel();
        int rows = model2.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model2.removeRow(i);
        }

    }

//**************************************************************************************************
    public static void ReceivePacket(int Prot) throws IOException {

//        try {
//            Socket2 = new DatagramSocket(Prot);
//        } catch (SocketException ex) {
//            Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        LinkedList <String> IP = new LinkedList<String>();
//         
//         
//        byte [] b1 = new byte[1024];
//        
//        DatagramPacket dp = new DatagramPacket(b1, b1.length);
//        
//      
//        
//          while (flageStop == true) {
//             
//              
//            Socket2.receive(dp);
//            
//            String str = new String(b1);
//            
//            System.out.println(" Client : " + str );
//            System.out.println("IP : " + dp.getAddress());
//            System.out.println("Prot : " + dp.getPort());
//
//            byte[] b2 = str.getBytes();
//
//            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, dp.getAddress(), dp.getPort());
//            Socket2.send(dp1);
//            
//             System.out.println(" here 1 ");
//            model2.addRow(new Object[]{" hi ",54});
//             System.out.println(" here 2");
//            
//        }
//        
        m1 = new Multi3(Prot);

        t1 = new Thread(m1);

        t1.start();

    }

    //******************************************************************************************
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PortNum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        IPAdd = new javax.swing.JLabel();
        ProtNum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        startBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PortNum.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PortNum.setText("Enter the Prot number :");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Server IP :");

        IPAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        ProtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProtNumActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "IP Address", "Prot Number", "Length"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        startBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ping_pong_project/testImage.png"))); // NOI18N
        startBtn.setText(" Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ping_pong_project/Go-back-icon1.png"))); // NOI18N
        backBtn.setText(" Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PortNum, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IPAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ProtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IPAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PortNum, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProtNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProtNumActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed

        // remove the old date on table in GUI
        deleteOldDateOnJTable();

        Multi3.CountPacket = 1;

        isStartBtnClicked = true;

        boolean isCorrectPortNumber = true;
        int Port = 0;

        if (ProtNum.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Please complete the input information !", " Wrong ", JOptionPane.ERROR_MESSAGE);

        } else {

            try {
                Port = Integer.parseInt(ProtNum.getText());

            } catch (Exception e) {

                isCorrectPortNumber = false;
            }

            if (isCorrectPortNumber == true) {

                try {

                    if (isStarBtntClickFirstTime == true || !(PortNum.getText().equals(PortNumber))) {

                        isStarBtntClickFirstTime = false;
                        PortNumber = PortNum.getText();

                        ReceivePacket(Port);

                    } else {
                        JOptionPane.showMessageDialog(null, "you are already create this Port !", " Wrong ", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Enter the correct Port number !", " Wrong ", JOptionPane.ERROR_MESSAGE);

            }

        }


    }//GEN-LAST:event_startBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        deleteOldDateOnJTable();

        Multi3.CountPacket = 1;

        ProtNum.setText("");

        isStarBtntClickFirstTime = true;

        if (isStartBtnClicked == true) {

             Thread.currentThread().interrupt();
            Multi3.Socket2.close();
        }

        StartPage.server1.setVisible(false);
        StartPage.Start_Page.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Server_UDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_UDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_UDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_UDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Server_UDP s = new Server_UDP();
                    s.setVisible(true);

                } catch (UnknownHostException ex) {
                    Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IPAdd;
    private javax.swing.JLabel PortNum;
    private javax.swing.JTextField ProtNum;
    private static javax.swing.JTable Table;
    private static javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JButton startBtn;
    // End of variables declaration//GEN-END:variables
}
