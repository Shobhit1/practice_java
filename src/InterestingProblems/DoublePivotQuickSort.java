package InterestingProblems;

import java.util.Arrays;
import java.util.Random;

public class DoublePivotQuickSort {
	public static final Random rand = new Random();
	public int[] swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;

		return array;
	}
	
	public int randomizedPartition(int[] array, int start, int end){
//		Random rand = new Random();
		int randomIndex = start + rand.nextInt(end-start+1);
		swap(array,randomIndex,end);
		return partition(array,start,end);
	}

	private int partition(int[] array, int start, int end){
		int x = array[end];
		int i = start-1;
		for(int j = start;j<end;j++){
			if(array[j] <= x){
				i++;
				swap(array,i,j);
			}
		}
		swap(array,i+1,end);
		return i+1;
	}

	public void simpleQuickSort(int[] array,int start, int end){

		if (end > start){
			int q = randomizedPartition(array, start, end);
			simpleQuickSort(array, start, q-1);
			simpleQuickSort(array, q+1, end);
		}
	}

	public static void main(String[] args) {
		DoublePivotQuickSort qs = new DoublePivotQuickSort();
		int[] array = {2,8,7,1,3,5,6,4,9,0,10};
		qs.simpleQuickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
}


