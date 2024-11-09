import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// N은 사람 수, M은 K개를 만드는데 걸리는 시간, K는 붕어빵의 갯수
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			// 각 손님이 오는 시간
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			boolean valid = true;
			// 처음 음식이 나오면 시간은 2, 갯수 2니까 갯수만큼 사람을 처리하는데
			// 시간보다 사람 오는 시간이 크면 true 아니면 false
			// 그 다음이 있으면 시간은 4, 갯수는 2
			// 0 0 2 2 2 2 4 4
			for(int i=0; i<arr.length; i++) {
				int guest_time = arr[i];
				int avail_bread = (guest_time / M) * K;
				
				if(avail_bread < i+1) {
					valid = false;
					break;
				}		
			}
			
			if(valid) {
				System.out.println("#" + test_case + " " + "Possible");
			} else {
				System.out.println("#" + test_case + " " + "Impossible");
			}
		}
	}

}
