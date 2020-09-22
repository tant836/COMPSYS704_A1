package POS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import org.compsys704.Ports;
import org.compsys704.SignalClient;

public class SignalServer implements Runnable {
	private int SERVER_PORT;
	public static final String IP = "127.0.0.1";

	public SignalServer(int p){
		SERVER_PORT = p;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("port: " + SERVER_PORT);
			ServerSocket ss = new ServerSocket(SERVER_PORT, 50, InetAddress.getByName(IP));
			while(true){
				Socket s = ss.accept();
				try{
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					String signame = ((String)ois.readObject()).split("\\.")[1];
					System.out.println("signal name: " + signame);
					Worker w = new Worker();
					if(signame.equalsIgnoreCase("requestliquid")) {
						System.out.println("herererere");
						s.getOutputStream().write(0);
					}else if(signame.equalsIgnoreCase("receivedliquid")) {
						
						s.getOutputStream().write(0);
					}else {
						s.close();
						continue;
					}
					
					w.setSignalName(signame);
					w.setObjectInputStream(ois);
					w.setSocket(s);
					new Thread(w).start();
				}catch(java.io.EOFException e){
					e.printStackTrace();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			//System.exit(1);;
		}
	}

}
