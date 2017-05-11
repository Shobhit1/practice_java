package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArraysAndStrings {
	
	/**
	 * The function takes linear time in giving the first character
	 * @author Shobhit
	 * @param input - Takes a string input
	 * @return returns the first non repeated character
	 */
	public char findFirstNonrepeatedCharacter(String input){
		char[] charArrayInput = input.toCharArray();
		char result = '0';
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : charArrayInput){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}
			else{
				map.put(c,1);
			}
		}
		
		for(char c : charArrayInput){
			if(map.get(c) == 1){
				result = c;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Takes two strings; an input string and one string that contains all the characters to be removed
	 * from the input string.
	 * 
	 * 
	 * @param input - Input String to perform the operation to
	 * @param remove - String containing the characters to be removed
	 * @return The input strings without the characters from the second string
	 */
	public String removeSpecifiedCharacters(String input, String remove){
		Set<Character> removeCharacters = createSetFromString(remove);
		
		StringBuilder sb = new StringBuilder();
		int inputLength = input.length();
		for(int x=0; x < inputLength; x++){
			char tempChar = input.charAt(x);
			if(!removeCharacters.contains(tempChar)){
				sb.append(tempChar);
			}
		}
		
		return sb.toString();
		
	}
	
	public Set<Character> createSetFromString(String input){
		int length = input.length();
		Set<Character> uniqueSet = new HashSet<Character>();
		for(int i=0 ; i < length ; i++){
			uniqueSet.add(input.charAt(i));
		}
		
		return uniqueSet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraysAndStrings as = new ArraysAndStrings();
		char result = as.findFirstNonrepeatedCharacter("total");
		
		System.out.println(result);
		
		
		String test = String.format("Shobhitbihbithbithbi%s", "77");
		System.out.println(as.removeSpecifiedCharacters(test, "77bith"));
	}

}
