package Problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by shobhitagarwal on 3/1/16.
 */
public class shortProject0h {

    public static void main(String[] args) {
        int[] inputTest = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 1, 2, 4, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 1, 5, 6, 7, 8, 1, 2, 3, 5, 6, 4, 2, 3, 5, 5, 5, 5, 6};
        System.out.println(shortProject0h.mostFrequentSorting(inputTest));

        System.out.println(shortProject0h.mostFrequentMap(inputTest));

    }


    //most frequent using sorting - ideally should take O(nlogn) time
    public static int mostFrequentSorting(int[] arr) {
        Arrays.sort(arr);

        int count = 0;
        int len = arr.length;

        int mostFreq = arr[0];
        if (len == 1) {
            return arr[0];
        }
        int countPrevious = 1;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                countPrevious++;
            } else {
                if (countPrevious > count) {
                    count = countPrevious;
                    mostFreq = arr[i];
                }
                countPrevious = 1;
            }
        }
        return mostFreq;
    }

    // using hashmap

    public static int mostFrequentMap(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }

        // now that we have the map, just loop over it and keep a track of the biggest value yet

        int result = arr[0];
        int tempCount = 0;
        for (Integer key : countMap.keySet()) {
            int tempValue = countMap.get(key); //to make sure that only one access call is done
            if (tempValue > tempCount) {
                tempCount = tempValue;
                result = key;
            }
        }

        return result;
    }

}
