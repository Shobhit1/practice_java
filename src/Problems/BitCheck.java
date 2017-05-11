package Problems;

public class BitCheck {
	public static void main(String[] args){
		int number = 9;
		int count = 0;
		while(number != 0){
			if((number  & 1) == 1){
				count++;
			}
			number = number >> 1;
		}
		System.out.println(count);
	}
}
