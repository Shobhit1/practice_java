package Problems;

import java.util.Scanner;

public class StringPangrams {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String sentence = scan.nextLine().trim();

        boolean[] alphabetArray = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            Character temp = Character.toLowerCase(sentence.charAt(i));
            if (temp >= 97 && temp <= 122) {
                alphabetArray[temp - 'a'] = true;
            }
        }

        if (check(alphabetArray)) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }

        scan.close();
    }

    public static boolean check(boolean[] input) {

        for (boolean bool : input) {
            if (!bool) {
                return false;
                // break;
            }
        }
        return true;
    }
}
