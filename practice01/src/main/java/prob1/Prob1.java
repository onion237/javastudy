package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		/* 코드 작성 */
		String result;
		int num;
		
		System.out.print("수를 입력하시오 : ");
		num = scanner.nextInt();
		
		if(num % 3 == 0) 
			result = "3의 배수입니다.";
		else
			result = "3의 배수가 아닙니다.";
		
		System.out.println(result);
		scanner.close();
	}
}
