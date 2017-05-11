package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);

//        int counter;
//        int sum1 = 0;
//        int sumN = 0;
//        counter = in.nextInt();
//        int count = 0;
//        for (int i = 1; i <= counter; i++) {
//            if (count == 0) {
//                int a = in.nextInt();
//                sum1 += a;
//            }
//            if (count == counter) {
//                int a = in.nextInt();
//                sumN += a;
//            }
//
//            System.out.print(sum1);
//            System.out.println();
//            System.out.print(sumN);
//
//        }

//        int num = in.nextInt();
//
////
//
        Solution sol = new Solution();
//
//        int result = sol.addDigits(num);
//
//        System.out.println(result);


//        String input = in.next();
//        int[] numInput = {1,1,2,3,6,7,7,8,9};
//        System.out.println(sol.reverseAString(input).toString());
//        sol.removeDuplicates(numInput);

        System.out.println(sol.isAnagram("cat", "tar"));
    }

    // adding digits can be done by using digital root
    // dr(n) = n - floor(n-1/9)
    private int addDigits(int num) {
        return (int) (num - (9 * Math.floor((num - 1) / 9)));
//        return x;
    }

    public String reverseAString(String input) {
        char[] arr = input.toCharArray();

        int lengthArr = arr.length;
        for (int i = 0; i < lengthArr / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[lengthArr - 1 - i];
            arr[lengthArr - 1 - i] = temp;
        }

        return String.valueOf(arr);
    }

    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        int repeatCount = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                repeatCount++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return len - repeatCount;
    }


    //checking for anagram without the hashmap
    public boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        if (first.equals(second)) {
            return true;
        }

//        char[] firstArray = first.toCharArray();

        int[] counterArray = new int[26];

        for (int i = 0; i < first.length(); i++) {
            counterArray[first.charAt(i) - 'a']++;
            counterArray[second.charAt(i) - 'a']--;
        }

        for (int count : counterArray) {
            if (count != 0) return false;
        }

        return true;

    }


}
