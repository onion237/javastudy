package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = null;
		while(true) {
			System.out.print(">");
			name = sc.nextLine().trim();
			name = name.split(" ")[0];
			
			try {
				InetAddress[] addresses = InetAddress.getAllByName(name);
				Arrays.stream(addresses).map(address -> address.toString().split("/")[1]).forEach(System.out::println);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
