package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int arrSize = 5;
		int[] intArray = new int[arrSize];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.println(arrSize + "개의 숫자를 입력하세요.");
		for(int i = 0; i < arrSize; i++) {
			intArray[i] = scanner.nextInt();
		}
		/* 배열에 저장된 정수 값 더하기 */
		for(int num : intArray) {
			sum += num;
		}
		/* 출력 */
		System.out.println("평균은 " + sum / arrSize +"입니다.");
		/* 자원정리 */
		scanner.close();
	}
}
