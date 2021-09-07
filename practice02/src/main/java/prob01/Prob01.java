package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액 : ");
		int amount = scanner.nextInt();
		int cnt;
		for (int money : MONEYS) {
			cnt = amount / money;
			if(cnt > 0) {
				System.out.println(money + " : " + cnt + "개");
				amount -= cnt * money;
			}
		}

		scanner.close();
	}
}