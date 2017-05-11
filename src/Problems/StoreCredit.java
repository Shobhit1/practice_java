package Problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by shobhitagarwal on 3/4/16.
 */
public class StoreCredit {
    public static void main(String[] args) {
        File file = new File(args[0]);

        Scanner scan;

        try {
            scan = new Scanner(file);

            int numberOfTestCases = scan.nextInt();

            for (int k = 0; k < numberOfTestCases; k++) {
                int creditAllowed = scan.nextInt();
                int sizeOfItems = scan.nextInt();

                int[] arrayOfItems = new int[sizeOfItems];
                for (int i = 0; i < sizeOfItems; i++) {
                    arrayOfItems[i] = scan.nextInt();
                }

                findStoreCredit(k, creditAllowed, arrayOfItems, sizeOfItems);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findStoreCredit(int numberOfCase, int credit, int[] listOfItems, int sizeOfItems) {
        int len = sizeOfItems;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (listOfItems[i] + listOfItems[j] == credit) {
                    System.out.println("Case #" + (numberOfCase + 1) + ": " + (i + 1) + " " + (j + 1));
                }
            }
        }
    }

}
