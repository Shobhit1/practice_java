package InterestingProblems;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList_DuplicateRemoval {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		
		ListIterator<Integer> it = list.listIterator();
		
		while(it.hasNext() ){
			if((it.next() == it.next()) && (it.nextIndex() <  list.size())){
//				System.out.println("Yes");
				it.remove();
				it.previous();
			}
			else{
				it.previous();
//				System.out.println("no");
			}
			
		}
		
		while(it.hasNext()){
			System.out.print(it.next());
		}
			
	}
}
