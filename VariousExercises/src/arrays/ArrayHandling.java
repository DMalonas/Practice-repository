package arrays;

public class ArrayHandling implements ArrayMethods {

    public void minimumBribes(int[] queue) {
        int cnt = 0;
        int len = queue.length;
        for (int i = 0; i <len; i++) {
            if (queue[i] > (i + 3)) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, queue[i]-1-1); j < i; j++){
                if (queue[j] > queue[i]){ 
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    
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

	@Override
	public long manipulateArray(int n, int[][] queries) {
		long arr[] = new long[n + 2];
		for (int i = 0; i < queries.length; i++) {
			int left = queries[i][0];
			int right = queries[i][1];
			int val = queries[i][2];
			arr[left] += val;
			arr[right + 1] -= val;
		}
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}


	
	
}
