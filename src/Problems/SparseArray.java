package Problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by shobhitagarwal on 5/11/17.
 */
public class SparseArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		HashMap<String, Integer> stringCount = new HashMap<String, Integer>();
		for (int i=0; i<a; i++){
			String s = in.next();
			if(stringCount.containsKey(s)){
				stringCount.put(s, stringCount.get(s) + 1);
			} else {
				stringCount.put(s, 1);
			}
		}
		int b = in.nextInt();

		for (int j=0; j<b; j++){
			String s2 = in.next();
			Integer count = stringCount.get(s2);
			System.out.println(count != null ? count : 0);
		}
	}
}
