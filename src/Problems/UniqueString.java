package Problems;

import java.util.Scanner;

class UniqueString{
	
	public static boolean checkUnique(String input){
		int n = input.length();
		for(int i=0 ; i< n; i++){
			for(int j = n-1; j > i ; j--){
				if(input.charAt(i) == input.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static boolean checkUniqueInLinear(String input){
		boolean[] checkArr = new boolean[256];
		int n = input.length();
		for(int i=0 ; i< n ; i++){
			int val  = input.charAt(i);
			if(checkArr[val]){			//the char is already been encounterd
				return false;
			}
			checkArr[val] = true;
		}
		return true;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input = scan.next();

//		System.out.println(checkUnique(input));
		System.out.println(checkUniqueInLinear(input));
	}
}