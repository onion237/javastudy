package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64.Encoder;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
		EchoServer.log("[server] connected by client[" + remoteAddr.getAddress().getHostAddress() + ":" + remoteAddr.getPort());
		try {
			// 4. I/O Stream 받아오기
			BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter response = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			while (true) {
				// 5. 데이터 읽기

				// blocking method
				System.out.println("---------------------------");
				String rcvString = request.readLine();
				System.out.println("---------------------------");
				System.out.println(rcvString);
				if (rcvString == null) {
					// client가 정상적으로 종료(close() 호출)
					EchoServer.log("[server] closed by client");
					break;
				}

				EchoServer.log(rcvString);
				response.println(rcvString);
			}
		} catch (SocketException e) {
			EchoServer.log("[server] suddenly closed by client");
		} catch (IOException e) {
			EchoServer.log("[server] error " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}