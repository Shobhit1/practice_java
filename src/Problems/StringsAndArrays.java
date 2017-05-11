package Problems;

import java.util.*;

public class StringsAndArrays {

    public static String compressString(String input) {

        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1); // constant time get
            } else {
                charCount.put(c, 1); // O(n) - because it makes the entry at the
                                     // end
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : charCount.keySet()) {
            sb.append(c);
            sb.append(charCount.get(c));
        }

        return sb.toString();
    }

    // Iterative using O(nlogn)
    public static void pairWithSum(int[] input, int sum) {

        Arrays.sort(input); // sorting in increasing order

        int l = 0;
        int r = input.length - 1;

        while (l < r) {
            if (input[l] + input[r] == sum) {
                // count++;
                System.out.println("Pair with given sum " + sum + " is (" + input[l] + ", " + input[r] + ")");
                // break;
                l++;
                r--;
            } else if (input[l] + input[r] > sum) {
                r--;
            } else {
                l++;
            }
        }
    }

    /**
     * Function to push all the 0 to either right or left side of an array
     * @param arrayInput - integer array as the input
     * @param leftSide - parameter so leftside which will be true if the zeroes need to shift to left.
     * 
     * @return The final array with 0s either on left or right side.
     */
    static void pushZeroToEnd(int[] arrayInput, boolean leftSide) {

        int length = arrayInput.length;
        Queue<Integer> setTemp = new ArrayDeque<Integer>();
        for (Integer x : arrayInput) {
            if (x != 0) {
                setTemp.add(x);
            }
        }

        if (!leftSide) {
            for (int i = 0; i < length; i++) {
                if (!setTemp.isEmpty()) {
                    arrayInput[i] = setTemp.remove();
                }

                else {
                    arrayInput[i] = 0;
                }

            }
        } else {
            int lengthOfZeroes = length - setTemp.size();
            for(int i=0; i<lengthOfZeroes; i++){
                arrayInput[i] = 0;
            }
            for(int k= lengthOfZeroes; k<length ; k++ ){  
                arrayInput[k] = setTemp.remove();
            }
        }

        System.out.println(Arrays.toString(arrayInput));

    }

    // using O(n)
    private static final int MAX = 100000; // Max size of Hashmap

    static void printpairsUsingMap(int arr[], int sum) {

        // Declares and initializes the whole array as false
        boolean[] map = new boolean[MAX];

        for (int i = 0; i < arr.length; ++i) {
            int find = sum - arr[i];

            if (find >= 0 && map[find]) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + find + ")");
            } else {
                map[arr[i]] = true;
            }
        }
    }

    public ArrayList<ArrayList<String>> anagramCheck(String[] list) {

        Map<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < list.length; i++) {
            String key = list[i];
            char[] characters = key.toCharArray();
            Arrays.sort(characters);
            key = new String(characters);

            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(list[i]);
            } else {
                ArrayList<String> listItem = new ArrayList<String>();
                listItem.add(list[i]);
                anagramMap.put(key, listItem);
            }

            // return result;
        }
        // System.out.println(anagramMap);
        Set<String> keys = anagramMap.keySet();
        ArrayList<String> listKeys = new ArrayList<String>();

        listKeys.addAll(keys);
        Collections.sort(listKeys);

        for (String item : listKeys) {
            result.add(anagramMap.get(item));
        }

        return result;

    }

    public static List<Point> closestPoints(List<Point> points, Point inputPoint, int numberOfPoints) {

        int x = inputPoint.x;
        int y = inputPoint.y;
        Map<Double, List<Point>> distanceMap = new HashMap<Double, List<Point>>();
        List<Point> result = new ArrayList<Point>();
        for (Point p : points) {
            int x1 = p.x;
            int y1 = p.y;
            double distance = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
            if (distanceMap.containsKey(distance)) {
                distanceMap.get(distance).add(p);
            } else {
                List<Point> pointList = new ArrayList<Point>();
                pointList.add(p);
                distanceMap.put(distance, pointList);
            }

        }
        Set<Double> keys = distanceMap.keySet();
        ArrayList<Double> listKeys = new ArrayList<Double>();
        listKeys.addAll(keys);
        Collections.sort(listKeys);

        for (int i = 0; i < numberOfPoints; i++) {
            result.addAll(distanceMap.get(listKeys.get(i)));
        }

        return result;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {

            return "(" + x + "," + y + ")";
        }

    }
    
    public static void main(String[] args) {
        // List<Point> points = new ArrayList<Point>();
        // Point inputPoint = new Point(5, 5);
        // points.add(new Point(-2, -4));
        // points.add(new Point(0, 0));
        // points.add(new Point(10, 15));
        // points.add(new Point(5, 6));
        // points.add(new Point(7, 8));
        // points.add(new Point(-10, -30));
        // points.add(new Point(5, 5));
        //
        // System.out.println(closestPoints(points, inputPoint, 2));

        // System.out.println("abcba".indexOf('a'));

        // System.out.println(compressString("abcabcaaaaaaqqssahfggfgfgfgfgf"));

        // int A[] = {1, 4, 45, 6, 10, 8, 3, 2};
        // int n = 0;
        // printpairsUsingMap(A, n);
        // pairWithSum(test, n);

//        pushZeroToEnd(test, false);
        
        int x = 5;
        
        System.out.println(x%2);
        
        
//        Stack<Integer> test = new Stack<Integer>();
//        
//        test.push(1);
//        
//        test.push(2);
//      test.pop();
//      
//      Queue<Integer> test2 = new ArrayDeque<>();
//      
//      test2.add(1);
//      test2.add(3);
//      
//      test2.remove();
//      test2.re
//      System.out.println(test2.contains(3));
//      System.out.println(test2);
//        
    }

}
