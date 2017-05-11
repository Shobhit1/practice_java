package Problems;

import java.util.Arrays;

public class CountingSort {
	
	public int findMax(int[] arr){
		int max = arr[0];
		for (int i=0; i< arr.length-1;i++){
			if (arr[i] >= arr[i+1]){
				max = arr[i];
			}
		}
		return max;
	}
	public int[] countSort(int[] array){
		int k = findMax(array);
		int[] count = new int[k+1];
		
		for (int i=0;i<array.length;i++){
			count[array[i]] = count[array[i]] +1;
		}
		
		for (int i=1; i<count.length;i++){
			count[i] = count[i-1]+count[i];
		}
		
		int[] sortedArray = new int[array.length+1];
		
		for(int x=0;x<array.length;x++){
			sortedArray[count[array[x]]] = array[x];
			count[array[x]] = count[array[x]] -1;
		}
		return Arrays.copyOfRange(sortedArray, 1, sortedArray.length);
	}

	public static void main(String[] args){
		int[] input = {1,3,5,2,4,6,10,20,30,11,12,23};
//		System.out.println((input.length));
		System.out.println(Arrays.toString(new CountingSort().countSort(input)));
	}
}
