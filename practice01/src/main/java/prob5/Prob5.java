package prob5;

import java.util.Arrays;
import java.util.List;

public class Prob5 {
	public static void main(String[] args) {
		String number, clap;
		char digit;
		List<Character> matchNum = Arrays.asList('3', '6', '9');
				
		for(int i = 1; i <= 99; i++) {
			number = String.valueOf(i);
			clap = "";
			
			for(int j = 0; j < number.length(); j++) {
				digit = number.charAt(j);
				if(matchNum.contains(digit)) clap += "짝";
			}
			
			if(clap.length() > 0)
				System.out.println(i + " " + clap);
		}
	}
}
