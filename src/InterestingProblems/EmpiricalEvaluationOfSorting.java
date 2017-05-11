package InterestingProblems;

import java.util.Random;

public class EmpiricalEvaluationOfSorting {
	
	private static int size = 8000000;
	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;
	
	
	/*
	 * Timer function
	 */
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
	
	/*
	 * Merge Sort
	 * O(nlogn)
	 */
	
	private void mergeSort(int[] array, int low, int high){
		int middle;
//		if(high-low < cutOff){
//			insertionSort(array);
//		}
		if(high > low){
			middle = (low+high)/2;
			mergeSort(array,low, middle);
			mergeSort(array,middle+1,high);
			merge(array,low,middle,high);
		}
	}
	
	/*
	 * Merge Function
	 * This is where all the magic happens in the merge sort
	 * The only problem is, it requires us to make two arrays using sorting
	 * As quick as any other algorithm.
	 */
	private void merge(int[] array, int low, int middle, int high){
		int n1 = middle-low + 1;
		int n2 = high - middle;
		
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		int i,j,k;
		for(i=0; i < n1; i++){
			left[i] = array[low + i];
		}
		
		for(j=0 ; j < n2; j++){
			right[j] = array[middle + j +1];
		}
		
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		i=0;
		j=0;
		
		for(k=low; k <= high; k++){		
			if(left[i] <= right[j]){
				array[k] = left[i];
				i++;
			}
			else{
				array[k] = right[j];
				j++;
			}
		}
	}
	/**
	 * Quick Sort method
	 * Uses a randomized element to partition the array into two parts and 
	 * then recursively sort both half
	 * @param array - the input array
	 * @param start - the starting index
	 * @param end - the ending index
	 */

	private void quickSort(int[] array, int start, int end){
//		if(end-start < cutOff){
//			insertionSort(array);
//		}
		if(start < end){
			int q = randomizedPartition(array, start, end);
			quickSort(array, start, q-1);
			quickSort(array, q+1, end);
		}
	}
	/*
	 * Randomizing the element that is used to divide the array
	 * Gives a better chance of a good split.
	 */
	private int randomizedPartition(int[] array, int start, int end){
		Random rand = new Random();
		int temp = start + rand.nextInt(end-start+1);
		swap(array,end, temp);
		return partition(array, start, end);
	}
	
	/*
	 * Method for paritioning
	 */
	private int partition(int[] array, int start, int end){
		int pivot = array[end];
		int i= start -1;
		for(int j = start; j<end; j++){
			if(array[j] <= pivot){
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, end);
		return i+1;
		
	}
	/*
	 * Swap function used in randomized partition, partition and Insertion sort
	 */
	private void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	/*
	 * Simple Insertion sort method
	 * Takes the array as input and just inserts each element in its proper position
	 * by scanning the whole array
	 * An expensive but simple algorithm - O(n2)
	 */
	void insertionSort(int[] array){
		for(int i=1; i < array.length; i++){
			int j=i ;
			while(j > 0 && (array[j-1] > array[j])){
				swap(array, j-1, j);
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * Generating a random array of 8 million elements and then sorting them using these algos
		 * 
		 */
		
		int[] arrMerge = new int[size];
		int[] arrQuick = new int[size];
//		int[] arrInsertion = new int[size];
		
		Random rand = new Random();
		//Filling the merge sort array
		for(int i=0; i<size; i++) {
			arrMerge[i] = new Integer(rand.nextInt(5*size));
		}
		
		//filling out the quick sort array
		for(int i=0; i<size; i++) {
			arrQuick[i] = new Integer(rand.nextInt(5*size));
		}
		
		/*//filling out the insertion sort array
		for(int i=0; i<size; i++) {
			arrInsertion[i] = new Integer(rand.nextInt(5*size));
		}*/
		
		
		EmpiricalEvaluationOfSorting sortingObject = new EmpiricalEvaluationOfSorting();
		System.out.println("Merge Sort");
		timer();
		sortingObject.mergeSort(arrMerge, 0, arrMerge.length-1);
		timer();

		System.out.println("Quick Sort");
		timer();
		sortingObject.quickSort(arrQuick, 0, arrQuick.length-1);
		timer();
		/*
		System.out.println("Insertion Sort");
		timer();
		sortingObject.insertionSort(arrInsertion);
		timer();*/
		
	}
}
