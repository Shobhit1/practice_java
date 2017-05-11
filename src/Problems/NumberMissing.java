package Problems;

import java.util.Arrays;
public class NumberMissing {

    // 2 methods can be employed.
    // 1st is to take the sum of the AP and then subtract the sum of the given numbers.
    // 2nd is to take a boolean array and use it as a flag (will require two loops - the 1st method will do as well)


    // Both the methods are O(n), but they may be a little sluggish for a large input especially the sum, because sum can be very very big in
    // some cases

    private int sumOfArray(int[] array) {
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }
        return sum;
    }

    private int sumOfProgression(int n) {
        return (n * (n + 1) / 2);
    }
    // 1st method

    private int findMissing(int[] array, int upperLimit) {
        int sampleSum = sumOfArray(array);
        int trueSum = sumOfProgression(upperLimit);

        return (trueSum - sampleSum);
    }

    // 2nd method

    private int findMissingUsingBoolean(int[] array, int upperLimit) {
        boolean[] markedArray = new boolean[upperLimit + 1];

        int len = array.length;

        for (int i = 0; i < len; i++) {
            markedArray[array[i]] = true;
        }
        int result = 0;
        for (int i = 1; i < upperLimit + 1; i++) {
            if (!markedArray[i]) {
                result = i;
            }
        }
        return result;
    }

    // Now if sorting is allowed - it should become as easy as one loop with two pointers

    private int findMissingSorted(int[] array, int upperLimit) {
        Arrays.sort(array);
        int len = array.length;
        int result = 0;
        for (int i = 0; i <= len / 2; i++) {
            int sum = array[i] + array[len - i - 1];
            if (sum != upperLimit + 1) {
                result = i;
//                return i;
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        NumberMissing obj = new NumberMissing();
        int[] input = {1, 2, 4, 5, 3, 7, 6, 10, 11, 9, 12};
        System.out.println(obj.findMissingSorted(input, 12));

    }

}
