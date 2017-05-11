package InterestingProblems;

import java.util.HashSet;

class Node {
	int data;
	Node next;

	public Node() {
	}
	public Node(Node node) {
		this.data = node.getData();
		this.next = node.getNext();
	}
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	public void display() {
		Node ptr = this;
		System.out.print(this.getData() + "->");
		ptr = this.getNext();
		while (ptr.getNext() != null) {
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData() + "\n");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Data : " + this.getData();
	}
}

public class ReversingLinkedList {

	public static void removeDuplicatesFromLinkedList(Node head) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while (head.next != null) {
			if (!set.contains(head.getData())) {
				set.add(head.getData());
				previous = head;
			} else {
				previous.next = head.next;
			}

			// System.out.println(set.toString());
			head = head.next;
		}
	}

	public static Node recursiveRecursion(Node head) {
		if (head == null) {
			return null;
		}
		if (head.getNext() == null) {
			return head;
		}

		Node second = head.getNext();
		head.setNext(null);
		Node reversed = recursiveRecursion(second);

		second.setNext(head);

		return reversed;
	}

	public static int length(Node head) {

		int count = 0;
		while (head != null) {
			count += 1;
			head = head.next;
		}
		return count;
	}

	// static Node newNode;
	// static Node previous;
	// public static void reverseHalfList(Node head){
	// int lengthOfList = length(head);
	//
	// int halfPoint = (lengthOfList + 1)/2;
	//
	// }

	public static Node nthToLast(Node head, int k) {
		if (k <= 0)
			return null;

		Node p1 = head;
		Node p2 = head;
		
		
		//Moving the p2 pointer to kth position
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null; 

			p2 = p2.next;
		}
		if(p2 == null) return null;
		//moving p1 and p2 at the same pace till p2 reaches the null/end
		//the difference between p1 and p2 should be k.
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;

	}

	public static void reverseList(Node head) {
		if (head == null) {
			return;
		}

		Node second = head.getNext();
		Node third = second.getNext();

		second.setNext(head);
		head.setNext(null);

		if (third == null) {
			// second.display();
			return;
		}

		Node current = third;

		Node previous = second;

		while (current != null) {
			Node next = current.getNext();
			current.setNext(previous);

			previous = current;
			current = next;
		}
		head = previous;

	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(1);
		node1.setNext(node2);
		Node node3 = new Node(3);
		node2.setNext(node3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(null);

		node1.display();
		removeDuplicatesFromLinkedList(node1);
		Node test = nthToLast(node1, 3);

		test.display();

		// reverseList(node1); //reverse working fine
		// node1.display();
		// recursiveRecursion(node1);

		// reverseHalfList(node1);
		// node7.display();

	}

}
