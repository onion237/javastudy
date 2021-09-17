package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class ChatServerThread extends Thread {
	private final Socket socket;
	private MessageBroker broker;
	private User user;
	Encoder encoder = Base64.getEncoder();
	Decoder decoder = Base64.getDecoder();

	public ChatServerThread(Socket socket, MessageBroker broker) {
		this.socket = socket;
		this.broker = broker;
	}

	@Override
	public void run() {
		BufferedReader request = null;
		try {
			request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			Response response = null;

			while (true) {
				String data = request.readLine();
				System.out.println(data);
				System.out.println("==================================");
				if (data == null) {
					quit();
					return;
				}

				String[] tokens = data.split(" ");

				switch (tokens[0]) {
				case "join":
					// user객체 생성
					ChatServer.log(new String(decoder.decode(tokens[1]), "utf-8"));
					user = new User(new String(decoder.decode(tokens[1]), "utf-8"), socket);

					// 이미 방에 존재하는 유저인지 검사(닉네임 기준)
					if (broker.isExist(user)) {
						response = new Response("fail");
						response.setDesc("이미 존재하는 닉네임입니다. 다른 닉네임을 입력해주세요.");
						responseToUser(response);
						break;
					}

					// 조인
					joinRoom();
					break;
				case "msg":
					if (user == null) {
						ChatServer.log("유저정보 없음");
						response = new Response("fail");
						response.setDesc("유저정보를 찾지 못했습니다.");
						responseToUser(response);
						break;
					}

					sendMessage(tokens[1]);
					break;
				case "quit":
					quit();
					return;
				default:
					ChatServer.log("알 수 없는 입력");
					responseToUser(new Response("fail", "알 수 없는 입력입니다."));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				quit();
			} catch (IllegalTypeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (request != null)
					request.close();
				if (user.getWriter() != null)
					user.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void responseToUser(Response response) {
		user.getWriter().println(response);
	}

	private void joinRoom() throws IllegalTypeException {
		Message message = new Message("join");
		message.setContent(user.getUserName() + "님이 입장하였습니다.");
		synchronized (broker) {
			broker.broadCast(message);
			broker.addUser(user);
			responseToUser(new Response("success", "채팅방에 입장하였습니다. (귓속말을 하려면,  :(닉네임) (메시지) 을 입력해주세요) "));
		}

		InetSocketAddress socketAddress = (InetSocketAddress) (user.getSocket().getRemoteSocketAddress());
		ChatServer.log("[join] : " + user.getUserName() + " - " + socketAddress.getAddress().getHostAddress() + ":"
				+ socketAddress.getPort());
	}

	private void quit() throws IllegalTypeException {
		Message message = new Message("quit");
		message.setContent(user.getUserName() + "님이 퇴장하셨습니다.");

		synchronized (broker) {
			if (broker.removeUser(user)) {
				broker.broadCast(message);

				InetSocketAddress socketAddress = (InetSocketAddress) (user.getSocket().getRemoteSocketAddress());
				ChatServer.log("[quit] : " + user.getUserName() + " - " + socketAddress.getAddress().getHostAddress()
						+ ":" + socketAddress.getPort());
			}
		}

	}

	private void sendMessage(String msg) throws IllegalTypeException {
		Message message = new Message("msg");
		message.setContentEncoded(msg);
		String decoded = null;
		
		try {
			decoded = new String(decoder.decode(msg), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message.setSender(this.user.getUserName());
		
		if(decoded != null && !decoded.isEmpty() && decoded.charAt(0) == ':') {
			User user = new User(decoded.substring(decoded.indexOf(':') + 1, decoded.indexOf(' ')));
			if(broker.isExist(user)) {
				System.out.println(this.user.getUserName() + "이 " + user.getUserName() + "에게 귓속말");
				
				message.setReceiver(user.getUserName());
				message.setContent(decoded.substring(decoded.indexOf(' ') + 1));
				synchronized (broker) {
					broker.sendTo(user, message);
				}
				
				return;
			}
		}
		
		synchronized (broker) {
			broker.broadCast(message);
		}
		ChatServer.log("[send message] : " + message.getSender() + " - " + decoded);
	}

}
