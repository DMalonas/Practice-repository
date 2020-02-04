package arrays;

public class ArrayHandling implements ArrayMethods {

	
	public int minimumSwaps(int[] arr) {
		int cnt = 0, tmp;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]  != i + 1) {
				tmp = arr[i];
				arr[i] = arr[arr[i] - 1];
				arr[tmp - 1] = tmp;
				i--;
				cnt++;
			}
		}
		return cnt;
	}
	
	
}
