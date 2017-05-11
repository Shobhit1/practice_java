package Problems;
/*
 * 
 * @author shobhitagarwal
 * Count Zero in a sorted array
 *
 */
public class CountZero {
	public static void main(String[] args){
		int[] x = {0,0,0,1};
		
		System.out.println(countZero(x));
	}
	public static int countZero(int[] array){
		int p = 0;
		int q = array.length - 1;
		
		while(p <= q){
			int middle = p + (q-p) /2;
			
			if(array[middle] < 1){
				p = middle + 1;
			}
			else{
				q = middle - 1 ;
			}
		}
		
		return p;
	}
}
