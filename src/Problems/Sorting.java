package Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Sorting {

	public void selectionSort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int minIndex = i;
			for (int j = i; j < input.length; j++) {
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			swap(input, i, minIndex);
		}
		System.out.println(Arrays.toString(input));
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

//		return array;
	}

	public int findMinElement(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
				}
			}
		}
		return min;
	}
	/**
	 * The worst kind of sort that there is - running time O(n^2)
	 **/
	public int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					swap(array, i, j);
				}
			}
		}
		return array;
	}

	public int binarySearch(int[] array, int start, int end, int element) {
		int middle = 0;

		while (start < end) {
			middle = (start + end) >>> 1;
			if (array[middle] == element) {
				return middle;
			} else if (array[middle] < element) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return start;
	}
	/*
	 * public int[] insertIntoArrayAtPosition(int[] array, int element, int
	 * position){ if(position > array.length) return null; // int count = 0;
	 * for(int i=0 ; i<array.length; i++){ if(i==position){ int temp = array[i];
	 * array[i] = element;
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * 
	 * public int[] mergeIntoSortedArray(int[] array1, int[] array2){ for(int
	 * elementFromArray2 : array2){ int positionToInsert = binarySearch() } }
	 */
	
	public static void insertionSort1(int len, int[] input){
	    int temp;
	    for(int i=0; i< len; i++){
	        for(int j=i ; j>0 ; j--){
	            if(input[j] < input[j-1]){
	                swap(input, j, j-1);
	            }
	        }
	    }
	    
	    System.out.println(Arrays.toString(input));
	    
	}
	
	
	public static void main(String[] args) {
//		Sorting sr = new Sorting();
//		int[] unSortedArray = {1, 4, 10, 0, 2, 9};
		// System.out.println(Arrays.toString(sr.swap(unSortedArray, 0, 4)));
		// sr.selectionSort(unSortedArray);
//		int[] sortedArray = sr.bubbleSort(unSortedArray);
//		System.out.println(Arrays.toString(sortedArray));

		// String result = (sr.binarySearch(sortedArray, 0,
		// sortedArray.length - 1, 11) != -1) ? "Match found" : "No Match";

		// System.out.println(result + " at " + sr.binarySearch(sortedArray, 0,
		// sortedArray.length - 1, 11) + "th position");
//		System.out.println(sr.binarySearch(sortedArray, 0,
//				sortedArray.length - 1, 8));
		
		
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		
		Integer[] arrIn = new Integer[len];
		
		for(int i=0; i< len ; i++){
		    arrIn[i] = scan.nextInt();
		}
		
		System.out.println("Input: First Line: " + len + "--- Second Line: " + Arrays.toString(arrIn));
		
		Arrays.sort(arrIn, Collections.reverseOrder());		
		System.out.println(Arrays.toString(arrIn));
//		insertionSort1(len, arrIn);
		

	}
}
