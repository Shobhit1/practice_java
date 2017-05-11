/****
 * Implementing code for arithmetic functions on very big numbers
 * Number needs to be stored in a list by storing the digits.
 */

package InterestingProblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_p3_arithmetic {

	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;


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

	public static void main(String[] args) {
		System.out.println("Please enter two numbers. The first number needs to be bigger than the second!");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String subtractResult;
		String number1 = scan.next();

		String number2 = scan.next();
		timer();

		LinkedList<Integer> number1List = stringToList(number1);	//converting the numbers from string to list
		LinkedList<Integer> number2List = stringToList(number2);	//converting the numbers from string to list

		String addResult = listToReverseString(add(number1List , number2List));

		if(checkNum1BiggerThanNum2(number1, number2)){

		subtractResult = listToReverseString(wholeNumberSubtract(number1List, number2List));
		}
		else{
			subtractResult = listToReverseString(wholeNumberSubtract(number2List, number1List));
			subtractResult = "-" + subtractResult;
		}

		System.out.println("Additon :" + addResult + " Subtraction Result :" + subtractResult);

		timer();
		scan.close();

	}

	/*
	 * Helper function to get the next element
	 */
	public static <T extends Comparable<? super T>> T next(Iterator<T> it){
		if(it.hasNext()){
			return it.next();
		}
		else{
			return null;
		}
	}
	/*
	 * Function to convert string to list.
	 * 
	 */
	public static LinkedList<Integer> stringToList(String data){
		LinkedList<Integer> result = new LinkedList<>();
		for(int i=0; i < data.length(); i++){
			result.add(data.charAt(i) - '0');
		}

		return result;
	}
	/*
	 * Function to convert list to string- can be used to get the output.
	 */
	public static String listToString(LinkedList<Integer> a){
		Iterator<Integer> it = a.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext()){
			sb.append(it.next());
		}

		return sb.toString();
	}
	/*
	 * List to string function but returns reverse of the string
	 * helps with printing the correct output in add case
	 */
	public static String listToReverseString(LinkedList<Integer> a){
		Iterator<Integer> it = a.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext()){
			sb.append(it.next());
		}

		return sb.reverse().toString();
	}

	/*
	 * Function to implement addition of two linked lists
	 * arithmetically
	 */

	public static LinkedList<Integer> add(LinkedList<Integer> num1List, LinkedList<Integer> num2List){
		LinkedList<Integer> num1ListTemp = new LinkedList<>(num1List);
		LinkedList<Integer> num2ListTemp = new LinkedList<>(num2List);


		LinkedList<Integer> finalListAdd = new LinkedList<>();
		int n1 = num1ListTemp.size();
		int n2 = num2ListTemp.size();
		int carry = 0;

		while(n1>0 || n2>0){
			if(n1 == 0){
				int numbertoAdd = carry + num2ListTemp.pollLast();
				if(numbertoAdd > 9){
					finalListAdd.add(numbertoAdd % 10);
					carry = numbertoAdd / 10;
				}
				else{
					finalListAdd.add(numbertoAdd);
					carry = 0;
				}
				n2 = num2ListTemp.size();
			}
			else if(n2==0){
				int numbertoAdd = carry + num1ListTemp.pollLast();
				if(numbertoAdd > 9){
					finalListAdd.add(numbertoAdd % 10);
					carry = numbertoAdd / 10;
				}
				else{
					finalListAdd.add(numbertoAdd);
					carry = 0;
				}
				n1 = num1ListTemp.size();
			}
			else{
				int last1 = num1ListTemp.pollLast();
				int last2 = num2ListTemp.pollLast();
				n1 = num1ListTemp.size();
				n2 = num2ListTemp.size();

				int add1 = last1+last2 + carry;

				if(add1 > 9){
					int add2 = add1%10;
					carry = add1/10;
					finalListAdd.add(add2);
				}
				else{
					finalListAdd.add(add1);
					carry = 0;
				}
			}
		}


		return finalListAdd;	

	}

	/*
	 * Function to check if the number1 is bigger than number2
	 * Takes O(N) time using strings
	 */
	public static boolean checkNum1BiggerThanNum2(String number1, String number2){

		int n1 = number1.length();
		int n2 = number2.length();


		if(n1 > n2){
			return true;
		}
		else if(n1 == n2){
			for(int i=0; i<n2; i++){
				if(number1.charAt(i) > number2.charAt(i)){
					return true;
				}
			}
		}
		else{
			return false;
		}
		return false;
	}


	/**
	 * Number subtraction 
	 * Method used: Whole Number Subtractions
	 * @param num1
	 * @param num2
	 * 
	 * Only works when the number 1 is bigger than the second number
	 * @return
	 */

	public static LinkedList<Integer> wholeNumberSubtract(LinkedList<Integer> num1List, LinkedList<Integer> num2List){

		LinkedList<Integer> num1ListTemp = new LinkedList<>(num1List);
		LinkedList<Integer> num2ListTemp = new LinkedList<>(num2List);

		int n1 = num1ListTemp.size();
		int n2 = num2ListTemp.size();

		int flag = 0;
		int subtractNum = 0;
		LinkedList<Integer> finalListSub = new LinkedList<>();


		while(n1 > 0 || n2 > 0){
			if(n1 == 0){
				int numToSub = num2ListTemp.pollLast();
				n2 = num2ListTemp.size();
				if(flag == 1){
					numToSub = numToSub - 1;

					if(numToSub < 0){
						finalListSub.add(numToSub + 10);
						flag = 1;
					}
					else{
						finalListSub.add(numToSub);
						flag = 0;
					}
				}
				else{
					finalListSub.add(numToSub);
					flag = 0;
				}
			}
			else if (n2 == 0){
				int numToSub = num1ListTemp.pollLast();
				n1 = num1ListTemp.size();
				if(flag == 1){
					numToSub = numToSub - 1;


					if(numToSub < 0){
						finalListSub.add(numToSub + 10);
						flag = 1;
					}
					else{
						finalListSub.add(numToSub);
						flag = 0;
					}
				}
				else{
					finalListSub.add(numToSub);
					flag = 0;
				}
			}
			else{

				int lastDigit1 = num1ListTemp.pollLast();
				int lastDigit2 = num2ListTemp.pollLast();

				n1 = num1ListTemp.size();
				n2 = num2ListTemp.size();
				if(flag == 1){
					if(lastDigit1 - lastDigit2 < 0){
						subtractNum = (int) (((lastDigit1 + 9) - lastDigit2));
						flag = 1;
						finalListSub.add(subtractNum);
					}
					else{
						subtractNum = (lastDigit1 - 1) - lastDigit2;
						flag = 0;
						finalListSub.add(subtractNum);
					}
				}
				else{
					if(lastDigit1 - lastDigit2 < 0){
						subtractNum = (int) (((lastDigit1+10) - lastDigit2));
						flag = 1;
						finalListSub.add(subtractNum);
					}
					else{
						subtractNum = lastDigit1 - lastDigit2;
						flag = 0;
						finalListSub.add(subtractNum);
					}
				}
			}	
		}
		return finalListSub;
	}
}
