import java.io.DataInputStream;
import com.google.gson.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerHandler {

	private static ServerHandler instance;
	
	Socket client;
	OutputStream outToServer;
	DataOutputStream out;
	InputStream inFromServer;
	DataInputStream in;
	GsonBuilder builder;
	Gson gson;

	private ServerHandler() {
		builder = new GsonBuilder();
		gson = builder.create();
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ServerHandler getInstance() {
		if(instance == null) {
			instance = new ServerHandler();
		}
		
		return instance;
	}

	public boolean CheckLogin(String username, String password) {
		String message = "1 " + username + " " + password;
		try {
			byte messageBytes[] = message.getBytes();

			out.write(messageBytes);

			int validation = in.readByte();
			if (validation == 1)
				return true;
			else if (validation == 0)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void AddShift(Shift shift) {
		String json = "2 " + gson.toJson(shift);
		//gson.fromJson(json, ShiftList.class);
		byte[] jsonBytes = json.getBytes();
		try {
			out.write(jsonBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ShiftList GetShiftList() {
		String message = "3";
		byte[] messageByte = message.getBytes();
		byte[] receivedBytes = new byte[61500];
		
		try {
			out.write(messageByte);
			in.read(receivedBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = new String(receivedBytes, StandardCharsets.UTF_8);

		ShiftList list = gson.fromJson(json, ShiftList.class);
		return list;
	}
}
