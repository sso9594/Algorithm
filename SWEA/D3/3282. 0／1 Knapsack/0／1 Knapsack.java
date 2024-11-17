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
			int N = sc.nextInt(); // 물건 갯수
			int K = sc.nextInt(); // 부피합 제한
			
			int[][] bag = new int[N+1][2];
			
			for(int i=0; i<N; i++) {
				bag[i][0] = sc.nextInt(); // 부피
				bag[i][1] = sc.nextInt(); // 가치
			}
			
			int[] dp = new int[K+1];
			
			for(int i=0; i<N; i++) {
				int weight = bag[i][0];
				int value = bag[i][1];
				
				for(int w=K; w>=weight; w--) {
					dp[w] = Math.max(dp[w], dp[w-weight] + value); 
				}
			}
			
			System.out.println("#" + test_case+ " " + dp[K]);
			
		}
	}
	

}