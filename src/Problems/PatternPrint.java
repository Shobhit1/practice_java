package Problems;

public class PatternPrint {
	public static void main(String[] args) {
		for (int i=0; i<4;i++){
			char a = 'a';
			for(int j=0;j<=i;j++){
				System.out.print(a++);
			}
			System.out.println();
		}
	}
}
