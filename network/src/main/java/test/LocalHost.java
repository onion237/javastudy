package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
	public static void main(String[] args) {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println(addr.getHostName());
			
			System.out.println(addr.getHostAddress());
			
			byte[] address = addr.getAddress();
			
			for(byte part : address) {
				System.out.print((part & 0xFF) + ".");
			}
			System.out.println();
			System.out.println(Integer.toBinaryString(-115));
			System.out.println(Integer.toBinaryString(141));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
