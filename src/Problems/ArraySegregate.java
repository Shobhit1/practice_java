package Problems;

import java.util.Arrays;

class ArraySegregate{
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

//		return arr; 
	}

	public static void main(String[] args){
		int[] input  = {-2,-3,3,2,1,0,-5,-4,-1,9};
		int n = input.length;
		
		int i=0;
		int j= n-1;
		
		while(i!=j){
			if(input[i] >= 0 && input[j] < 0){
				swap(input,i,j);
				i++;
				j--;
			}
			else if(input[i] < 0 && input[j] < 0){
				i++;
			}
			else {
				j--;
			}
		}

		System.out.println(Arrays.toString(input));
	}
}