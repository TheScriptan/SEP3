package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;

public abstract class IHandler {
	
	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s;
	final PersistenceHandler pers;
	
	public IHandler(Socket s, DataInputStream dis, DataOutputStream dos, PersistenceHandler pers) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
		this.pers = pers;
	}
	
	public void acceptMessage(String message) {};
}
