package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public final static int PORT = 9999;
	public static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		//1. UDP 소켓 생성
		try(DatagramSocket socket = new DatagramSocket(9999);) {
			
			while(true) {
				//2. UDP 소켓으로부터 읽고 쓰기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE); 
				//읽기
				socket.receive(rcvPacket); // blocking, Byte-Stream 읽어서 저장, blocking을 푸는 기준은?
				
				byte[] rcvData = rcvPacket.getData();
				int len = rcvPacket.getLength();
				String message = new String(rcvData, 0, len, "utf-8");
				
				System.out.println("[server] receive : " + message);
				
				//쓰기
				byte[] sndData = message.getBytes("utf-8"); 
				DatagramPacket sndPacket = new DatagramPacket(sndData, len, rcvPacket.getAddress(), rcvPacket.getPort()); 
				
				socket.send(sndPacket);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
