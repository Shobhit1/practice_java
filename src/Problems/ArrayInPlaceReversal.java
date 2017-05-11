package Problems;

public class ArrayInPlaceReversal {

    public static void main(String[] args) {
        int[] arrEx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ArrayInPlaceReversal.reversal(arrEx);
    }


    public static void reversal(int[] arrEx) {
        int length = arrEx.length;

        for (int i = 0; i <= (length / 2) - 1; i++) {
            int temp = arrEx[i];
            arrEx[i] = arrEx[length - 1 - i];
            arrEx[length - 1 - i] = temp;
        }
        for (int a : arrEx) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    public static void moveZeroesToBack(int[] arr) {

    }


}
