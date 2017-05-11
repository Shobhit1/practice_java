package InterestingProblems;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchGenerics {
	//	private static int size = 2000000;
	//  private static int trials = 2000000;
	private static int size = 20;
	private static int trials = 5;
	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;
	private static boolean match = false;
	
	
	public static<T extends Comparable<? super T>> int  binarySearch(T[] A, int p, int r, T x) {
		int q = 0;

		while(p <= r) {
			q = (p+r) >>> 1; //middle element being found
			int cmp = A[q].compareTo(x); 	//this funtion is kinda same as e1.equals(e2) gives 0,<0,>0 equal, less than
			//or greater than the number
			if (cmp < 0) { //A[q] < x, so x is in the right half
				p = q+1;
			} else if (cmp == 0) {  // x found
				match = true;
				return q;
			} else { // A[q] > x, so x is not in the right half
				r = q-1;
			}
		}
		match = false;
		return p;
	}


	public static void timer()
	{
		if(phase == 0) {
			startTime = System.currentTimeMillis();
			phase = 1;
		} else {
			endTime = System.currentTimeMillis();
			elapsedTime = endTime-startTime;
			System.out.println("Time: " + elapsedTime + " msec.");
			//			memory();
			phase = 0;
		}
	}
	public static void main(String[] args) {
		int success = 0;
		int closeSearches = 0;
		//		int[] arr = new int[size];
		Integer[] iarr = new Integer[size];
		Random rand = new Random();
		//		for(int i=0; i<size; i++) {
		//			arr[i] = rand.nextInt(10*size);
		//		}
		//		Arrays.sort(arr);

		for(int i=0; i<size; i++) {
			iarr[i] = new Integer(rand.nextInt(10*size));
		}

		Arrays.sort(iarr);

		int[] searchKey = new int[trials];
		for(int i=0; i<trials; i++) {
			searchKey[i] = rand.nextInt(10*size+50);
		}

		//		success = 0;
		System.out.printf("Searching for %d elements in the array" , trials);
		timer();
		for(int j=0;j<trials;j++){
			Integer x = new Integer(searchKey[j]);
			int position = binarySearch(iarr, 0, size-1, x);
			//			binarySearch(iarr, 0, size-1, x);
			if (match){
				success ++;
				System.out.printf("\nThe element %d is present at index %d", x,position);
			}
			else{
				closeSearches++;
				if (position >= size){
					System.out.printf("\nThe element %d is greater than the whole array", x);
				}
				else{
					System.out.printf("\nThe element closest to %d is %d at index %d", x,iarr[position],position);
				}

			}
		}
		System.out.printf("\nSuccessful searches: " + success);
		System.out.println("\nClose searches: " + closeSearches);
		timer();

	}
}


