package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "115.22.10.141";
	private static final int SERVER_PORT = 9999;
	
	public static void main(String[] args) {
		// 1. Client 소켓 생성
		// 2. Server에 Connect
		
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			
			log("Connected To Server.");
			
			BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter request = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); //charset 인자를 주지않으면, 자동으로 시스템의 charset으로 세팅함
			while(true) {				
				// 쓰기
				System.out.print(">> [send to server] ");
				// 키보드 입력
				String input = inputReader.readLine();
		
				if(input == null || "exit".equals(input))
					break;
				
				request.println(input);
				
				// 읽기
				String responseString = response.readLine();
				if (responseString == null) {
					//server로부터의 정상종료
					log("[client] closed by server");
				}
				
				System.out.print("<< [response by server]");
				System.out.println(responseString);
			}
		} catch (SocketException e) {
			log("[client] suddenly closed by server: " + e);
		} catch (IOException e) {
			log("[client] error: " + e);
		}

	}

	private static void log(String logString) {
		System.out.println(logString);
	}
}
