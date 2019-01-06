/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_mypenguin_signup;

import java.awt.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import projet_mypenguin_signup.ClientSocket;

import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author Roat9
 */
public class Chat_ihm extends javax.swing.JFrame{

    /**
     * Creates new form Chat_ihm
     */	
    public Chat_ihm(ClientSocket csock) {
    	this.csock = csock;
        initComponents();
        afficheFriendList(csock);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField(); 
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea(); //liste d'amis connect�
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea(); //afficher les msgs
        jLabel2 = new javax.swing.JLabel();
        
        
        //msg_text = new javax.swing.JTextField();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("ENTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, -1, -1));

        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Envoyer un message");
       //jTextField1.setUI(new HintTextFieldUI("Search", true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 540, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        //jScrollPane3.setViewportView(jTextArea3);
        jTextArea3.setEditable(false);
        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 240, 630));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setEditable(false);
        
        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 540, 630));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("img/light.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        
        
        
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 960, 688));
        
        pack();
        
        jTextField1.setBackground(new Color(0,0,0,0));
        jTextArea1.setBackground(new Color(0,0,0,100));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    	 try {
         	//String msg = msg_text.getText().trim();
         	//msg = "INSERT \"'00001', '"+msg+"', NOW(), '01'\" message_txt";
         	//buf = msg.getBytes();
         	//DatagramPacket packet = new DatagramPacket (buf, buf.length, address, 4242);
         	//socket.send(packet);
             String msgout =  jTextField1.getText().trim();
             String request = "INSERT§'00002', '"+msgout+"', NOW(), '01'§message_txt";
             csock.sendMsg(request);
         } catch(Exception ae){
        	 
         }
    	 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
   /* public static String[] split(String text, String delimiter) {
        java.util.List<String> parts = new java.util.ArrayList<String>();

        text += delimiter;

        for (int i = text.indexOf(delimiter), j=0; i != -1;) {
            String temp = text.substring(j,i);
            if(temp.trim().length() != 0) {
                parts.add(temp);
            }
            j = i + delimiter.length();
            i = text.indexOf(delimiter,j);
        }

        return parts.toArray(new String[0]);
    }
    */
    private void afficheFriendList(ClientSocket csock) {
    	int i = 0;
    	//StringBuilder sb = new StringBuilder(array.length);
    	 try {
         	
         	
         	String userOnline = "SELEWH§pseudo§users§statut§online";
 	        
         	csock.sendMsg(userOnline);
         	String str = csock.recvMsg();  
         	
         	String splitStr[] = str.split("\\Â§");
         	
 	       /* 
 	        String split[]=users.split("\\§");
 	        while (splitStr != null) {
 	        	String[] userEnLigne = splitStr[i];
 	        	i++;
 	        }
 	        String split[] = StringUtils.split(str,"§");
         	String delimiter = "-";
            String result[] = split(str, delimiter);
 	        */
         	
         	
            /*
            for(String s:result) {
            	array[i] = arrayNumbers;
                sb.append(array[i]);
            }
                
            */
 	        jTextArea3.setText(splitStr[0]);
 	       
 			
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    
    private void afficheMsg() {
    	try {
         	//ClientSocket csocket = new ClientSocket("127.0.0.1",4242);
         	 
         	String msgRoom = "SELEWH§date_msg_txt"; 
 	       
         	csock.sendMsg(msgRoom);
         	String msg = csock.recvMsg();     	
 	        
 	        jTextArea1.setText(msg);
 	       
 			
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnknownHostException, IOException {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });   
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat_ihm(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    
   // private javax.swing.JTextField msg_text;
    
	private static final long serialVersionUID = 1L;
	private ClientSocket csock;
	//static Socket s;
	//static DataInputStream din;
	//static DataOutputStream dout;
    // End of variables declaration//GEN-END:variables
}
