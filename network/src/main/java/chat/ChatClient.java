package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;
	public static void main(String[] args) {
		String name = null;
		
		
		Scanner scanner = new Scanner(System.in);
		
		Socket socket = null;
		BufferedReader response = null;
		PrintWriter request = null;
		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();
		try {
			//소켓 생성
			socket = new Socket();
			//connect
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//I/O객체 획득
			response = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			request = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
						
			//name 인코딩 및 방입장
			while(true) {
				while((name = getUserName(scanner)) == null);
				
				String encoded = new String(encoder.encode(name.getBytes("utf-8")), "utf-8");
				System.out.println("encoded request : " + encoded);
				request.println("join " + encoded);
				String[] responseData = response.readLine().split(" ");
				System.out.println("encoded response : " + responseData[2]);	
				
				System.out.println(new String(decoder.decode(responseData[2]),"utf-8"));
				if("success".equals(responseData[1])) {
					break;
				}
			}
			
			//메시지 수신용 스레드 시작
			new ChatClientThread(socket).start();
			
			//키보드 입력 소켓에 출력
			while(true) {
				String input = scanner.nextLine();
				
				if("quit".equals(input)) request.println("quit");
				else request.println("msg " + new String(encoder.encode(input.getBytes("utf-8")),"utf-8"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			request.println("quit");
			try {
				socket.close();
				scanner.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static String getUserName(Scanner scanner) {
		System.out.println("대화명을 입력하세요.");
		System.out.print(">>> ");
		String name = scanner.nextLine();
		
		if (name.isEmpty()) {
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			return null;
		}		
		return name;
	}
}
