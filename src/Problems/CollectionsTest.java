package Problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shobhitagarwal on 5/11/17.
 */
public class CollectionsTest {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Strawberry");

		Iterator<String> fruitIterator = fruits.iterator();
		while(fruitIterator.hasNext()) {
			String fruit = fruitIterator.next();
			System.out.println(fruit);
			if ("Apple".equals(fruit)) {
				fruitIterator.remove();
			}
		}
		System.out.println(fruits.toString());
	}
}
