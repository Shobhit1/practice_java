package Problems;

public class SelectAlgo {
	public int median(int[][] list){
		int[] medianOfMedians = new int[list.length];
//		return list.length;
		for (int i=0;i<list.length;i++){
			int n = list[i].length;
			if((n)%2 == 0){
				medianOfMedians[i] = list[i][((n/2 - 1)+(n/2 + 1))/2];
			}
			else{
				medianOfMedians[i] = list[i][n/2];
			}
		}
		int median = 0;
		for (int j=0; j<medianOfMedians.length;j++){
			int l = medianOfMedians.length;
			if (l== 0){
				median = medianOfMedians[(((l/2)-1)+((l/2)+1))/2];
			}
			else median = medianOfMedians[l/2];
		}
		return median;
	}
	public static void main(String[] args){

		int[][] array = {{1,3,5},{2,4,6},{10,20,30},{11,12,23}};
		System.out.println(new SelectAlgo().median(array));
	}
}
