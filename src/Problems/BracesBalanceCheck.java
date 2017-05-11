package Problems;

import java.util.HashMap;
import java.util.Stack;

public class BracesBalanceCheck {

    public boolean braceCheck(String s) {
        int lengthOfInput = s.length();

        if (lengthOfInput == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < lengthOfInput; i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
//                    break;
            }
        }
        return stack.isEmpty() ? true : false;

    }


    public HashMap<String, Integer> wordCounter(String document) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word : document.split(" ")) {
            String key = word.toLowerCase().replaceAll("[^A-Za-z]", "");
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        BracesBalanceCheck bc = new BracesBalanceCheck();
        String braceInput = "(){}";
        System.out.println(bc.braceCheck(braceInput));

//		System.out.println(bc.wordCounter("Gabba gabba hey, gabba gabba hey!"));

    }

}
