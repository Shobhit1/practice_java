package Problems;

import java.util.ArrayList;



public class LongMultiplication {

	public ArrayList<String> mutliply(String first, String second){
		String zeroes = "";
		String eachStep = "";
		//		StringBuilder zeroesStringBuilder = new StringBuilder();
		String[] multi = new String[10];
		//		String[] add = new String[];
		ArrayList<String> add = new ArrayList<String>();
		for (int i=first.length()-1; i>=0;i--){
//			StringBuilder zeroBuilder = new StringBuilder();
			int x = first.length()-1-i;
			while(x>0){
				zeroes = zeroes + "0";
				x--;
			}
			System.out.println(zeroes);
//			zeroes = zeroBuilder.toString();
//			zeroes.format(format, args);
//			if (multi[Character.getNumericValue(first.charAt(i))].length() > 0){
//				return null;
//			}
//			else{
				int j = second.length()-1;
				int mult = 0;
				int base = 0;
				int carry = 0;
				StringBuilder s = new StringBuilder();
				while(j>=0){
					mult = (Character.getNumericValue(first.charAt(i))) * (Character.getNumericValue(second.charAt(j))) + carry;
					base = mult%10;
					carry = mult/10;
					s.append(base);
					
					j--;
				}
				if (carry==1){
					s.append(carry);
				}
				s.reverse();
				eachStep = s.toString();
				multi[Character.getNumericValue(first.charAt(i))] = eachStep;
				
//			}
			eachStep = eachStep + zeroes;
			add.add(eachStep);
			zeroes = "";
		}
//		zeroes ="";
		
		
		return add;
		
	}
	
//	public String addForMultiply(ArrayList<String> arr){
//		
//	}
	public static void main(String[] args) {
		System.out.println(new LongMultiplication().mutliply("123", "456"));
//		String s = "";
////		s.concat("0");
//		s = s + "0";
////		String formatted = 
//		System.out.println(s);
		

	}

}



