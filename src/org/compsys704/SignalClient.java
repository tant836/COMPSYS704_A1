package org.compsys704;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;


public class SignalClient implements ActionListener{

	Socket s = new Socket();
	ObjectOutputStream oos = null;
	int port;
	final String ip = "127.0.0.1";
	
	String dest;
	
	public SignalClient(int p, String dest){
		this.dest = dest;
		port = p;
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			//System.exit(1);;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(s.isClosed()){
				s = new Socket();
				s.connect(new InetSocketAddress(ip, port), 10);
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(dest);
				int resp = s.getInputStream().read();
				if(resp < 0)
					throw new ConnectException("Not thru");
			}
			oos.writeObject(new Object[]{true});
			Thread.sleep(50);
			oos.writeObject(new Object[]{false});
		}
		catch (IOException | InterruptedException ee) {
			try {s.close();} catch (IOException e1) {
				e1.printStackTrace();
				//System.exit(1);
			}
		}
		
	}
	
	public void sendInteger(int value) {
		PrintWriter out;
    	//Socket clientSocket;
		try {
			if(s.isClosed()){
				s = new Socket("127.0.0.1", 12345);
				//s.connect(new InetSocketAddress(ip, port), 10);
				//oos = new ObjectOutputStream(s.getOutputStream());
				
				
			}
			out = new PrintWriter(s.getOutputStream(), true);
			
			//OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8);
			
			JSONObject obj = new JSONObject();
			
//			obj.put("name", dest.split("\\.")[1]);
//		    obj.put("cd", dest.split("\\.")[0]);
//		    obj.put("status", true);
//		    obj.put("value", new Integer(value));
			obj.put("name", "sentliquid");
		    obj.put("cd", "FillerCD");
		    obj.put("status", true);
		    obj.put("value", new Integer(value));
		    
		    //oos.writeObject(obj);
		    out.println(obj.toString());
			System.out.println("sent");
			Thread.sleep(50);
			obj.put("status", false);
			
			out.println(obj.toString());
			System.out.println("done");
			
//			
//        	
//            try {
//				clientSocket = new Socket("127.0.0.1", 12345);
//				out = new PrintWriter(clientSocket.getOutputStream(), true);
//        		
//				JSONObject obj = new JSONObject();
//				
//				obj.put("name", "sentliquid");
//			    obj.put("cd", "FillerCD");
//			    obj.put("status", true);
//			    obj.put("value", new Integer(23432));
//				
//        		out.println(obj.toString());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		catch (IOException ee) {
			try {s.close();} catch (IOException e1) {
				e1.printStackTrace();
				//System.exit(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
