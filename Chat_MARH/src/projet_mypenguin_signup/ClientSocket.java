package projet_mypenguin_signup;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientSocket {

	private Socket s;
	private DataInputStream din;
	private DataOutputStream dout;
	private boolean conn;
	
	public ClientSocket(String addr, int port) throws UnknownHostException, IOException {
		conn = connect(addr, port);
		if(conn == false) {
			System.out.println("Connexion error");
		}
	}
	 
	public boolean connect(String addr, int port) {
		try {
		    s = new Socket(addr,port);
		    din = new DataInputStream(s.getInputStream());
		    dout = new DataOutputStream(s.getOutputStream());
		}catch (SocketException exception) {
            exception.getMessage();
            return false;
        }catch (Exception exception) {
        	exception.getMessage();
        	return false;
        }
		return true;
	}
	
	public void sendMsg(String req) throws IOException {
		byte[] request = req.getBytes();
		try {
			dout.write(request);
			dout.close();
		}
		catch(Exception e){
			
		}
	}
	
	public String recvMsg() throws IOException {
		String res = "";
		try {
			res = din.readLine();
			din.close();
		}
		catch(Exception e){
			
		}
		return res;
	}
}
