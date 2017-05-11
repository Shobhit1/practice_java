package InterestingProblems;

import java.util.Iterator;



/***
 * The problem takes two sorted linked lists and then merges both of them into one sorted linked lists 
 * @author shobhitagarwal
 *
 */
public class LinkedList_P2 {
	/**
	 * Class to implement Linked List
	 */
	class Node<T extends Comparable<? super T>>{
		private T data;
		private Node<T> next;

		public Node() {
		}

		public Node(T data){
			this.data = data;
		}

		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		/*
		public void display(){
			Node<T> ptr = this;
			System.out.print(this.getData() + "->");
			ptr = this.getNext();
			while (ptr.getNext() != null)
			{
				System.out.print(ptr.getData()+ "->");
				ptr = ptr.getNext();
			}
			System.out.print(ptr.getData()+ "\n");
		}
		 */
	}

	/**
	 * Helper function to check and get the next value in the linkedlist
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


//	public static <T extends Comparable<? super T>> LinkedList<T> merge(LinkedList<T> l1, LinkedList<T> l2){




	}
