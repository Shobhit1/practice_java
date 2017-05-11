package Problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by shobhitagarwal on 6/22/15.
 */
public class BracesCheck {

    public static void main(String[] args) {
//        System.out.print("Hello");

        String input = "[{}]()[{{()}}]";

//        HashMap<Character, Integer> characterCountMap = check(input);
        System.out.println(check(input));

    }

    private static String check(String input) {


//        HashMap<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
//        for(int i=0; i<input.length(); i++){
////            System.out.println(input.charAt(i));
//            if(characterCountMap.containsKey(input.charAt(i))){
//                characterCountMap.put(input.charAt(i), characterCountMap.get(input.charAt(i)) + 1);
//            }
//            else {
//                characterCountMap.put(input.charAt(i), 1);
//            }
//
//        }
//
//        return characterCountMap;

        Character[] openingBraces = {'{', '(', '['};
        Character[] closingBraces = {'}', ')', ']'};
        List<Character> openingBracesList = Arrays.asList(openingBraces);
        List<Character> closingBracesList = Arrays.asList(closingBraces);
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<input.length();i++){
            Character brace = input.charAt(i);

            if(openingBracesList.contains(brace)){
                stack.push(brace);
            }
            else if(closingBracesList.contains(brace)){
                if(!stack.isEmpty()){
                    Character temp = stack.pop();
                    if(brace == ')' && temp != '('){
                        return "Fail " + temp;
                    }
                    else if(brace == '}' && temp != '{'){
                        return "Fail " + temp;
                    }
                    else if(brace == ']' && temp != '['){
                        return "Fail " + temp;
                    }
                }
                else{
                    return "empty stack";
                }
            }
            else{
                return "invalid input";
            }
        }

        if(stack.isEmpty()){
            return "Pass";
        }

        return "Outside";

    }




}
