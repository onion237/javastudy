package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class ChatServer {
	private static int port = 9999;
	public static void main(String[] args) {
		if(args.length > 0)
			port = Integer.parseInt(args[0]);
		
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(port));;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
