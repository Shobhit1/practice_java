package InterestingProblems;

import java.util.Arrays;
import java.util.Random;

public class SelectionProblem {
	
	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;
	private static int size = 100000000;
	
	public static void timer(){
		if(phase == 0){
			startTime = System.currentTimeMillis();
			phase = 1;
		}
		else{
			endTime = System.currentTimeMillis();
			elapsedTime = endTime-startTime;
			System.out.println("Time: " + elapsedTime + " msec.");
			phase = 0;
		}
	}
	
	
	//Take 1
	public int selectTake1(int[] array , int k){
		Arrays.sort(array);
		
		return array[array.length - k];
	}
	
	
	
	public static void main(String[] args){
		int[] arr = new int[size];
		Random rand = new Random();
		
		for(int i=0;i<arr.length;i++){
			arr[i] = rand.nextInt(size);
		}
		
		timer();
		System.out.println(new SelectionProblem().selectTake1(arr, 30));
		timer();
	}
}
