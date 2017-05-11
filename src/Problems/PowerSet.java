package Problems;

import java.util.ArrayList;

public class PowerSet {
	public ArrayList<ArrayList<Integer>> powerSet(int[] arr){

		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		int powerSetSize = 1 << arr.length;	//equivalent to math.pow(2,n)
		for(int i=0;i<powerSetSize;i++){
			temp = new ArrayList<Integer>();
			for(int j=1; j<= arr.length;j++){
				if((i & (1 << (j-1))) > 0){
					temp.add(arr[j-1]);
				}
			}
			result.add(temp);
		}
		return result;
	}
	
	public void check(int a){
		while (a!=1){
			if((a&1)==1){
				System.out.println("Not power of two");
				break;
			}
			else{
				a = a>>>1;
			}
			if (a==1){
				System.out.println("power of two");
			}
		}
		
	}
	public void setBit(int a, int n){
		int x = 1<<n;
		System.out.println(a | x);
	}
	public static void main(String[] args) {
//		int[] array = {1,2,3};
//		System.out.println(new PowerSet().powerSet(array));
//		System.out.println(4<<1);
//		new PowerSet().check(29);
//		System.out.println(1<<3);
		new PowerSet().setBit(44, 4);
	}

}
