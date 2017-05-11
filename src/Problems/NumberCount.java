package Problems;

import java.util.Scanner;

public class NumberCount {
	
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int numberToBeChecked = scan.nextInt();
			
			
			
			//logic to convert int number into digits
			/*
			int count = 0;
			int temp = numberToBeChecked;
			while(temp>0){
				count++;
				temp = temp/10;
			}
			
			int count2 = 0;
			int i = (int)Math.pow(10, count-1);
			while(i>0){
				int digit = (numberToBeChecked/i)%10;
				 if(numberToBeChecked % digit == 0){
					 count2++;
				 }
				 
				 i = i/10;
			}
			
			
			//convert the number to digits using string
			
			System.out.println(count2);
			*/
			int count2 = 0;
//			return;
			String number = String.valueOf(numberToBeChecked);
			
			for(int j=0; j<number.length();j++){
				int digit = number.charAt(j) - '0';
				System.out.println(digit);
				if(numberToBeChecked%digit == 0){
					count2++;
				}
			}
			System.out.println(count2);
			
			return;
		}
		
		
		
		scan.close();
	}

}
