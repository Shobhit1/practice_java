package Problems;
public class RodCutting {
	public int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public int cutRod(int arr[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max_val = max(max_val, arr[i] + val[i - j - 1]);
				val[i] = max_val;
			}
		}
		return val[n];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(new RodCutting().cutRod(arr, arr.length - 1));
	}

}
