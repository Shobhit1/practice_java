package InterestingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Assignment4Problemf {
	public static int findDistinct(int[] arr){
		/*
		 * Construction of the countMap
		 */
		Map<Integer,Integer> countMap = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			int key = arr[i];
			if(countMap.containsKey(key)){
				countMap.put(key, countMap.get(key)+1);
			}
			else{
				countMap.put(key, 1);
			}
		}
		//checking if the element is distinct or not
		//Replaces the element with an element in the array - swaps them
		int i = 0;
		int k = 0;
		while(i < arr.length){
			if(countMap.get(arr[i]) == 1){
				swap(arr,k,i);
				k++;
			}
			i++;
		}
		
		return k;
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,11,12};
		System.out.println("Original ArraY: " + Arrays.toString(arr));
		System.out.println("No. of Distinct elements: " + findDistinct(arr));
		System.out.println("Changed Array: " + Arrays.toString(arr));
	}
	
}
