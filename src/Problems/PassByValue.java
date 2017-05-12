/**
 * name
 */
import java.util.Arrays;
public class PassByValue {

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void shout(int num){
    num++;
  }

  public static void main (String[] args) {
    // int[] test = {1, 2, 3};
    // PassByValue ps = new PassByValue();
    // ps.swap(test, 0, 1);
    // System.out.println(Arrays.toString(test));
    int num = 1;
    int myNum = num;
    shout(myNum);
    System.out.println(myNum);
  }
}
