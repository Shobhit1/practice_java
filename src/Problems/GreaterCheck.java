package Problems;

import java.util.Scanner;

public class GreaterCheck {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String number1 = scan.next();
		String number2 = scan.next();

		int n1 = number1.length();
		int n2 = number2.length();


		if(n1 > n2){
			System.out.println("Yes");
		}
		else if(n1 < n2){
			System.out.println("No");
		}
		else{
			for(int i=0; i<n2; i++){
				if(number1.charAt(i) > number2.charAt(i)){
					System.out.println("Yes");
				}
			}
		}
		scan.close();

	}
}
