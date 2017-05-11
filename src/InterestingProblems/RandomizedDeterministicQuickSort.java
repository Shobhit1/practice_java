 package InterestingProblems;

import java.util.Random;

public class RandomizedDeterministicQuickSort {


	private static int size = 80000000;
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



	/**
	 * Quick Sort method
	 * Uses a randomized element to partition the array into two parts and
	 * then recursively sort both half
	 * @param array - the input array
	 * @param start - the starting index
	 * @param end - the ending index
	 */

	void quickSort(int[] array, int start, int end){
		if(start < end){
			int q = randomizedPartition(array, start, end);
			quickSort(array, start, q-1);
			quickSort(array, q+1, end);
		}
	}

	/**
	 * QuickSort using median of three partition
	 * @param array
	 * @param start
	 * @param end
	 */

	void medianOfThreeQuickSort(int[] array, int start, int end){
		if(start < end){
			int q = medianPartition(array, start, end);
			medianOfThreeQuickSort(array, start, q-1);
			medianOfThreeQuickSort(array, q+1, end);
		}
	}

	/*
	 * Using deterministic quick sort method.
	 * This uses the end of the array as the pivot
	 */
	void deterministicQuickSort(int[] array, int start, int end){
		if(start < end){
			int q = partition(array, start, end);
			deterministicQuickSort(array, start, q-1);
			deterministicQuickSort(array, q+1, end);
		}
	}

	/*
	 * Randomizing the element that is used to divide the array
	 * Gives a better chance of a good split.
	 */
	int randomizedPartition(int[] array, int start, int end){
		Random rand = new Random();
		int temp = start + rand.nextInt(end-start+1);
		swap(array,end, temp);
		return partition(array, start, end);
	}

	int medianPartition(int[] array, int start, int end){
		int middle = (start+end)/2;
		if(array[middle] < array[start]){
			swap(array,start,middle);
		}
		if(array[middle] > array[end]){
			swap(array,middle,end);
		}
		if(array[end] < array[start]){
			swap(array,start,end);
		}

		swap(array, middle, end);
		return partition(array,start,end);
	}

	/*
	 * Method for paritioning
	 */
	int partition(int[] array, int start, int end){
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



	public static void main(String[] args) {
		int[] arrQuick = new int[size];
		Random rand = new Random();

		for(int i=0; i<size; i++){
			arrQuick[i] = rand.nextInt(5*size);
		}

		int[] arrQuickRandom = new int[size];

		for(int i=0; i<size; i++){
			arrQuickRandom[i] = rand.nextInt(5*size);
		}

		int[] arrMedianOfThreeQuick = new int[size];

		for(int i=0; i<size; i++){
			arrMedianOfThreeQuick[i] = rand.nextInt(5*size);
		}

		RandomizedDeterministicQuickSort rd = new RandomizedDeterministicQuickSort();

		System.out.println("Determinstic QuickSort");
		timer();
		rd.deterministicQuickSort(arrQuick, 0, arrQuick.length-1);
		timer();


		System.out.println("Randomised QuickSort");
		timer();
		rd.quickSort(arrQuickRandom, 0, arrQuickRandom.length-1);
		timer();

		System.out.println("Median of Three quickSort");
		timer();
		rd.medianOfThreeQuickSort(arrMedianOfThreeQuick, 0, arrMedianOfThreeQuick.length-1);
		timer();
	}


}
