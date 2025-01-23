import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		int minNum1 = 0;
		int minNum2 = 0;

		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length-1;

		while(left < right){
			int result = arr[right] + arr[left];

			if(Math.abs(result) < Math.abs(min)){
				min = result;
				minNum1 = arr[left];
				minNum2 = arr[right];
			}

			if(result > 0){
				right--;
			} else{
				left++;
			}
		}

		System.out.printf("%d %d\n", minNum1, minNum2);
	}
}
