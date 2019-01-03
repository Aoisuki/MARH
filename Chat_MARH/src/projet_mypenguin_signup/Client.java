package projet_mypenguin_signup;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
    
    public Client() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);
        msg_area.getAccessibleContext().setAccessibleName("");
        msg_area.setEditable(false);
        msg_area.setLineWrap(true);

        msg_send.setText("Envoyer");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(msg_send))
                .addContainerGap())
        );

        msg_text.getAccessibleContext().setAccessibleName("");
        msg_send.getAccessibleContext().setAccessibleName("");
        msg_send.getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        try {
        	//String msg = msg_text.getText().trim();
        	//msg = "INSERT \"'00001', '"+msg+"', NOW(), '01'\" message_txt";
        	//buf = msg.getBytes();
        	//DatagramPacket packet = new DatagramPacket (buf, buf.length, address, 4242);
        	//socket.send(packet);
            String msgout = msg_text.getText().trim();
            String request = "INSERT§'00002', '"+msgout+"', NOW(), '01'§message_txt";
            byte[] req = request.getBytes();
            dout.write(req);
        } catch(Exception ae){}
    }

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
//    	try {
//	    	socket = new DatagramSocket();
//	    	address = InetAddress.getByName("localhost");
//    	} catch (Exception e) {}
        try {
           s = new Socket("127.0.0.1",5000);
           din = new DataInputStream(s.getInputStream());
           dout = new DataOutputStream(s.getOutputStream());
           String msgin="";
             
            while(!msgin.equals("disconnect")) {
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim()+"\nServer:\t"+msgin);                
            }
        }catch (Exception e) {}
        
    }

    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
//	private static DatagramSocket socket;
//	private static InetAddress address;
//	private byte[] buf;
}