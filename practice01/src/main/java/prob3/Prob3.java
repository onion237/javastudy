package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/* 코드 작성 */
		int num, sum;

		System.out.print("숫자를 입력하세요 : ");
		num = scanner.nextInt();
		sum = 0;
		
		if (num % 2 == 0) {
			for (int i = 0; i <= num; i++) {
				if(i % 2 == 0) sum += i;
			}
		} else {
			for (int i = 0; i <= num; i++) {
				if(i % 2 != 0) sum += i;
			}
		}
		System.out.println(sum);
		
		scanner.close();
	}
}
