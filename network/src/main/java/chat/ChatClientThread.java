package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Decoder decoder = Base64.getDecoder();
		try {
			BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String rcvString = response.readLine();
				String[] message = null;

				if (rcvString == null)
					break;

				message = rcvString.split(" ");

				if ("response".equals(message[0])) {
					// 메시지 수신 외에 요청에 대한 응답처리가 필요하다면 이곳에 작성
				} else {
					String content = new String(decoder.decode(message[1]), "utf-8");
					String sender = new String(decoder.decode(message[2]), "utf-8");
					String receiver = new String(decoder.decode(message[3]), "utf-8");
					if ("all".equals(receiver))
						receiver = "모두";
					System.out.println("[" + sender + " - " + receiver + "에게] " + content);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(socket.isClosed()) {
				System.out.println("연결이 종료되었습니다.");
			}else {
				e.printStackTrace();				
			}
		}

	}

}
