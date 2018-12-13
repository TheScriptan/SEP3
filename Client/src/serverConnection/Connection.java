package serverConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

	Socket s;
	DataInputStream input;
	DataOutputStream output;
	
	
	public Connection(String serverAddress, int port) {
		
		try {
			s = new Socket(serverAddress,port);
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if(!s.isClosed())
				s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DataInputStream getInput() {
		return this.input;
	}
	
	public DataOutputStream getOutput() {
		return this.output;
	}
}
