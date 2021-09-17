package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//TIME_WAIT상태에서도 소켓 포트 번호 할당이 가능하도록 하기 위해서..
			serverSocket.setReuseAddress(true);
			
			// 2. binding
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 9999));
			Socket socket = null;
			// 3. accept
			while("1".equals("1")) {
				socket = serverSocket.accept();
				
				InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
				
				System.out.println("[server] connected by client[" + remoteAddr.getAddress().getHostAddress() + ":" + remoteAddr.getPort());
				
			}
			
			try {
				// 4. I/O Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while(true) {
					//5. 데이터 읽기
					// blocking method
					byte[] buffer = new byte[256];
					
					// rcv 버퍼로부터 buffer로 복사한 바이트의 수 return
					int readByteCount = is.read(buffer);
					if (readByteCount == -1) {
						// client가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					
					
					String rcvString = new String(buffer,0,readByteCount,"utf-8");
					System.out.print(rcvString);
					os.write(rcvString.getBytes("utf-8"));
				}
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client");
			} catch (IOException e) {
				System.out.println("[server] error " + e);
			} finally {
				try {
					if(socket != null && !socket.isClosed())
						socket.close();					
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("[server] error " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
