package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TopCoderSortingTuts {

    private static long startTime, endTime, elapsedTime;
    private static int phase = 0;

    public static void timer() {

        if (phase == 0) {
            startTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            phase = 1;
        } else {
            endTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            elapsedTime = endTime - startTime;
            System.out.println("Time: " + elapsedTime + " microsec.");
            phase = 0;
        }
    }

    void bubbleSort(int[] arrayInput) {

        // the outer loop is required for all the elements to be sorted
        for (int i = 0; i < arrayInput.length; i++) {
            // just one go - it sorts almost all the data
            for (int j = 0; j < arrayInput.length - 1; j++) {
                if (arrayInput[j] > arrayInput[j + 1]) {
                    int temp = arrayInput[j];
                    arrayInput[j] = arrayInput[j + 1];
                    arrayInput[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arrayInput));
    }

    void checkForDuplicate(String input) {

        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) - 'a');
        }
    }

    static String sortedString(String input) {

        char[] contentArray = input.toLowerCase().toCharArray();
        Arrays.sort(contentArray);

        return new String(contentArray);
    }

    boolean checkForPermutationUsingSort(String s1, String s2) {

        // System.out.println(sortedString(s1));
        // System.out.println(sortedString(s2));
        if (sortedString(s1).equals(sortedString(s2))) {
            return true;
        }
        return false;

    }

    boolean checkForPermutationWithoutSortCheck(String s1, String s2) {

        HashMap<Character, Integer> mapTemp = new HashMap<Character, Integer>();

        char[] tempChar1 = s1.toLowerCase().toCharArray();

        for (Character c : tempChar1) {
            if (mapTemp.containsKey(c)) {
                mapTemp.put(c, mapTemp.get(c) + 1);
            } else {
                mapTemp.put(c, 1);
            }
        }

        char[] tempChar2 = s2.toLowerCase().toCharArray();

        for (Character c2 : tempChar2) {
            if (!mapTemp.containsKey(c2)) {
                return false;
            } else {
                mapTemp.put(c2, mapTemp.get(c2) - 1);
            }
        }

        for (Integer i : mapTemp.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }

    String replaceSpaces(String s) {

        char[] temp = s.toCharArray();
        int len = s.length();

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (temp[i] == ' ') {
                count++;
            }
        }

        int newLen = len + 2 * (count);

        char[] newA = new char[newLen];
        int j = 0;
        for (int i = 0; i < len; i++) {

            if (temp[i] == ' ') {
                newA[j] = '%';
                j++;
                newA[j] = '2';
                j++;
                newA[j] = '0';
                j++;
            } else {
                newA[j] = temp[i];
                j++;
            }
        }

        return new String(newA);
    }

    boolean checkRotationInString(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        } else {
            String s1s2 = s1 + s2;
            return s1s2.contains(s2);
        }

    }

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != val) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
        int count = 0;
        for(int k=0; k<nums.length; k++){
            if(nums[k] != val){
                count++;
            }
        }
        return count;
    }

    
    public void removeElementQuick(int[] nums, int val) {
        int pointer1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer1++] = nums[i];
            }
        }
        
        System.out.println(pointer1);
        
    }
    
    public void isAPowerOf2(int number){
        int x = 1;
        while(x != 128){
            if(x == number || (x << 1) == number){
                System.out.println(true);
                break;
            }
            x = x << 1;
        }
        System.out.println(false);
    }
    
    public static void main(String[] args) {

        TopCoderSortingTuts obj = new TopCoderSortingTuts();
//
//        int[] input = {0, 1, 0, 3, 12};
//
//        timer();
//        obj.removeElementQuick(input,0);
//        timer();
        obj.isAPowerOf2(12);
    }
}
