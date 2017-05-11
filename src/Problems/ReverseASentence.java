package Problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseASentence {
    public static void main(String[] args) {
        Scanner scan;
        String[] input;

        try {

            File file = new File(args[0]);
            scan = new Scanner(file);
            int number = scan.nextInt();
            scan.nextLine();
            input = new String[number];
            for (int i = 0; i < number; i++) {
                input[i] = scan.nextLine().toString();
            }

            reverseASen(input);

            scan.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

    public static void reverseASen(String[] input) {
        int i=1;
        for(String sentence: input){

            String[] sentenceArray = sentence.split("\\s");

            Stack<String> stack = new Stack<>();

            for (String word : sentenceArray) {
                stack.push(word.trim());
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + i + ": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop().trim() + " ");
            }

            System.out.println(sb.toString());
            i++;
        }
    }
}
