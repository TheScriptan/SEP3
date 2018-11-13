import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerHandler {
	
	Socket client;
	OutputStream outToServer;
	DataOutputStream out;
	InputStream inFromServer;
	DataInputStream in;
	
	public ServerHandler() {
	      String serverName = "127.0.0.1";
	      int port = Integer.parseInt("5000");
	      try {
	         System.out.println("Connecting to " + serverName + " on port " + port);
	         client = new Socket(serverName, port);
	         
	         System.out.println("Just connected to " + client.getRemoteSocketAddress());
	         outToServer = client.getOutputStream();
	         out = new DataOutputStream(outToServer);
	         
	         inFromServer = client.getInputStream();
	         in = new DataInputStream(inFromServer);
	         } catch (IOException e) 
	      {
	         e.printStackTrace();
	      }
	}
	
	public boolean CheckLogin(String username, String password) {
		String message = "1 " + username + " " + password;
		try{
			byte messageBytes[] = message.getBytes();
			
			out.write(messageBytes);
			
			int validation = in.readByte();
			if(validation == 1) return true;
			else if(validation == 0) return false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
