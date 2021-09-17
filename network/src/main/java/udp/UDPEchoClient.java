package udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	public static final int SERVER_PORT = UDPEchoServer.PORT;
	public static final String SERVER_IP = "127.0.0.1";
	public static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null;
		DatagramPacket rcvPacket = null;
		DatagramPacket sndPacket = null;
		
		try {
			scanner = new Scanner(System.in);
			socket = new DatagramSocket();
			while(true) {
				System.out.print(">> " );
				String line = scanner.nextLine();
				byte[] sndData = line.getBytes("utf-8");
				sndPacket = new DatagramPacket(sndData , sndData.length, new InetSocketAddress(SERVER_IP, SERVER_PORT));
				socket.send(sndPacket);
							
				rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(rcvPacket);
				System.out.println(new String(rcvPacket.getData(), "utf-8"));
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(scanner != null) scanner.close();
			if(socket != null && !socket.isClosed()) socket.close();
		}
	}
}
