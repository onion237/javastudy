package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) {
		// 1. Client 소켓 생성
		// 2. Server에 Connect
		OutputStream os = null;
		InputStream is = null;
		try (Socket socket = new Socket()) {
			// 1-1. 소켓 버퍼 사이즈 확인
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize + " : " + sndBufferSize);

			// 1-2. SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);

			// 1-3. SO_TIEOUT - blocking socket method의 timeout 설정 (read, accept)
			socket.setSoTimeout(3000);

			// client에서도 바인딩 가능, 명시적 바인딩 하지 않을 시 connect시 임시포트로 자동바인딩
//			socket.bind(new InetSocketAddress(5555));
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("Connected To Server.");

			is = socket.getInputStream();
			os = socket.getOutputStream();

			// 쓰기
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			os.write(input.getBytes("utf-8"));

			// 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				System.out.println("[client] closed by server");
			}

			String response = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println(response);

		} catch (SocketTimeoutException e) {
			System.out.println("[client] timeout");
		} catch (SocketException e) {
			System.out.println("[client] suddenly closed by server: " + e);
		} catch (IOException e) {
			System.out.println("[client] error: " + e);
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
