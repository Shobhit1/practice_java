package Problems;

import java.util.Scanner;

public class GreyCode{
	
	public static void main(String[] args){
		Scanner scan;
		String number;
		String result;

		try{
			scan = new Scanner(System.in);
				number = scan.next();

				int i=0;
				int j=1;

				StringBuilder sb = new StringBuilder();
				sb.append(number.charAt(i) - '0');  

				while(j < number.length()){
					sb.append((number.charAt(i) - '0') ^ (number.charAt(j) - '0'));
					i++;
					j++;
				}

				result = sb.toString();
				System.out.println(result);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}