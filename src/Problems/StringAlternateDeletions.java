package Problems;

import java.util.Scanner;

public class StringAlternateDeletions {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfInput = scan.nextInt();

        // System.out.println(numberOfInput);
        String[] inputArray = new String[numberOfInput];
        int[] countofDeletionsArray = new int[numberOfInput];

        for (int i = 0; i < numberOfInput; i++) {
            String s = scan.next();
            int count = 0;
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                }
            }
            countofDeletionsArray[i] = count;
            System.out.println(count);
        }
    }
}
