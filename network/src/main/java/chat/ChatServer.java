package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	private static int port = 9999;
	public static void main(String[] args) {
		if(args.length > 0)
			port = Integer.parseInt(args[0]);
		
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", port));
			MessageBroker broker = new MessageBroker();
			while(true) {
				Socket socket = serverSocket.accept();			
				new ChatServerThread(socket, broker).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void log(String log) {
		System.out.println(log);
	}
}
