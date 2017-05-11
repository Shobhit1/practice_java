package InterestingProblems;

public class CuckooHashingInsert {
	static int tableSize = 16;
	
	static int hash(int h){
		h ^= (h >>> 20) ^ (h >>> 12);
		h = (h ^ (h >>> 7) ^ (h >>> 4));
		return h % tableSize;
	}
	
	public static void main(String[] args) {
		System.out.println("\nHashing on Integer class (Table size: 16):\nInteger\tHashcode    Mod n\tIndex");
		for(int i=1; i<=10; i++) {
		    Integer x = new Integer(i*tableSize);
		    System.out.println(x + "\t" + x.hashCode() + "\t      " + x.hashCode()%tableSize + "\t\t  " + hash(x.hashCode()));
		}

		System.out.println("\nNew integer 65600 has hash code: " + new Integer(65600).hashCode());
	}
}
