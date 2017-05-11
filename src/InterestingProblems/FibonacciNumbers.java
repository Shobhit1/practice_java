package InterestingProblems;

import java.util.Scanner;

public class FibonacciNumbers {
	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;
	private static int p;
	/**
	 * Timer function to check the time taken
	 * by a function
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
	 * 
	 * @param number
	 * @param p
	 * @param fib
	 * @return fibonacci number at a given number mod p
	 * Function to implement fibonacci without DAC
	 * This takes linear time as we are calculating each value
	 */
	public long fibonacciStraight(long number, int p){
		long zero = 0 % p;
		long first = 1 % p;
		long result = 0 % p;
		for(int i=2;i<=number;i++){
			result = (zero % p  + first % p) % p;
			zero = first % p;
			first = result % p;
		}
		return result % p;
	}
	
	/**
	 * Function to write fibonacci with recursion
	 * @param args
	 * this takes exponential time. So not advised
	 */
	
	public long fibonacciRecursive(long number){
		if ((int) number == 0){
			return 0 % p;
		}
		else if ((int) number == 1){
			return 1 % p;
		}
		else{
			return fibonacciRecursive(number-1) % p + fibonacciRecursive(number-2) % p; 
		}
	}
	
	/**
	 * Fibonacci using DAC
	 * @param args
	 */
	public long[][] matrixMultiplication(long[][] matrix1, long[][] matrix2, int mod){
		long[][] result = new long[2][2];
		result[0][0] = ((matrix1[0][0] * matrix2[0][0]) % mod + (matrix1[0][1] * matrix2[1][0]) % mod);
		result[0][1] = ((matrix1[0][0] * matrix2[0][1]) % mod + (matrix1[0][1] * matrix2[1][1]) % mod);
		result[1][0] = ((matrix1[1][0] * matrix2[0][0]) % mod + (matrix1[1][1] * matrix2[0][1]) % mod);
		result[1][1] = ((matrix1[1][0] * matrix2[0][1]) % mod + (matrix1[1][1] * matrix2[1][1]) % mod);
		
		return result;
	}
	public long[][] exponentMatrix(long[][] matrix1, long power, int mod){
		long[][] result;
		if (power == 1){
			return matrix1;
		}
		result = exponentMatrix(matrixMultiplication(matrix1, matrix1,mod), power/2, mod);
		if (power % 2 != 0){
			return matrixMultiplication(result, matrix1, mod);
		}
		else{			
			return result;
		}
	}
	
	public long fibonacci(long number, int mod){
		long[][] matrix = {{1, 1}, {1, 0}};
		long[][] result = exponentMatrix(matrix, number-1,mod);
		
		return result[0][0] % mod;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		long number = scan.nextLong();
		p = scan.nextInt();
		
		FibonacciNumbers fb = new FibonacciNumbers();
		System.out.println("Time taken by O(n) method");
		
		timer();
		System.out.println(fb.fibonacciStraight(number, p));
		timer();
		
		System.out.println("Time by O(logn) method: ");

		timer();
		System.out.println(fb.fibonacci(number, p));
		timer();

		
		scan.close();
	}

}
