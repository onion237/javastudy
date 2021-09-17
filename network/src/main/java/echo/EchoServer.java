package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. binding
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 9999));

			// 3. accept
			while(true) {
				Socket socket = serverSocket.accept();
				
				new EchoServerReceiveThread(socket).start();
			}
		} catch (IOException e) {
			log("[server] error " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}
}
