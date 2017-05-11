package Problems;

public class StringConcat 
{

	private static String replace(String input) {
//		char first = input.charAt(0);
		if(Character.isUpperCase(input.charAt(0)) && ("AEIOU".indexOf(input.charAt(0)) == 0)){
			input = Character.toUpperCase(input.charAt(2)) + input.substring(2,input.length()) + input.charAt(0) + "yay";
		}
		else if ("aeiou".indexOf(input.charAt(0)) == 0){
			input = input.substring(1,input.length()) + input.charAt(0) + "ayay";
		}
		else{
			input = input.substring(1, input.length()) + Character.toLowerCase(input.charAt(0)) + "ay";
		}
		return input;
	}

	public static void main(String[] args) {
		String input = "Apple";
		System.out.println(replace(input));

	}


}
