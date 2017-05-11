package InterestingProblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/***********************************
 * The problem takes two linked lists 
 * implementing two sorted lists and then 
 * implement union and intersections of the sets
 * 
 * @author shobhitagarwal
 *
 ***********************************/


public class LinkedList_P1 {

	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;


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
			phase = 0;
		}
	}

	/**
	 * Helper function to get the next element
	 * @param it
	 * @return
	 */
	public static <T extends Comparable<? super T>> T next(Iterator<T> it){
		if(it.hasNext()){
			return it.next();
		}
		else{
			return null;
		}
	}
	/**
	 * Function that takes two linked lists and returns the intersection
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static <T extends Comparable<? super T>> LinkedList<T> intersect(LinkedList<T> l1, LinkedList<T> l2){
		LinkedList<T> finalList = new LinkedList<T>();
		Iterator<T> it1 = l1.iterator();
		Iterator<T> it2 = l2.iterator();
		T x1 = next(it1);
		T x2 = next(it2);

		while(x1 != null && x2 != null){

			int comp = x1.compareTo(x2);

			if(comp < 0){
				x1 = next(it1);
			}
			else if(comp > 0){
				x2 = next(it2);
			}
			else{
				finalList.add(x1);
				x1 = next(it1);
				x2 = next(it2);
			}
		}
		return finalList;
	}

	/**
	 * Function that returns the union list of the two given linked lists
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static <T extends Comparable<? super T>> LinkedList<T> union(LinkedList<T> l1, LinkedList<T> l2){

		LinkedList<T> finalList = new LinkedList<T>();

		Iterator<T> it1 = l1.iterator();	//Iterators for the two lists
		Iterator<T> it2 = l2.iterator();

		T x1 = next(it1);
		T x2 = next(it2);


		//Running the loops till either one of the loop becomes null
		while(x1 != null || x2 != null) {
			if(x1 == null){
				finalList.add(x2);
				x2 = next(it2);
			}
			else if(x2 == null){
				finalList.add(x1);
				x1 = next(it1);
			}

			else{

				int comp = x1.compareTo(x2);

				if (comp < 0){
					finalList.add(x1);
					x1 = next(it1);

				}
				else if (comp > 0){
					finalList.add(x2);
					x2 = next(it2);

				}
				else {
					finalList.add(x1);
					x1 = next(it1);
					x2 = next(it2);


				}
			}
		}

		return finalList;
	}


	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		//Just creating two linked lists - can be done randomly
		timer();
		Random rand = new Random();
		//	creating lists of 1000 size; 
		for(int i=0; i<=1000 ; i++){
			list1.add((1 + rand.nextInt(501)));   //range of 0-1000
			list2.add((1 + rand.nextInt(501)));
		}
		timer();


		timer();
		LinkedList<Integer> list = intersect(list1, list2);
		LinkedList<Integer> listUnion = union(list1, list2);
		timer();
		System.out.println("Intersection Results --------- ");
		if (list.isEmpty()){
			System.out.println("No common elements found in the Lists");
		}
		else{
			Iterator<Integer> it1 = list.iterator();
			System.out.println("Intersection Result: ");
			while(it1.hasNext()){
				System.out.print(it1.next() + " ");

			}
		}

		System.out.println();
		System.out.println("Union Results --------- ");
		if (listUnion.isEmpty()){
			System.out.println("No common elements found in the Lists");
		}
		else{
			Iterator<Integer> it = listUnion.iterator();
			System.out.println("Union Result: ");

			while(it.hasNext()){
				System.out.print(it.next() + " ");
			}
		}

	}

}
