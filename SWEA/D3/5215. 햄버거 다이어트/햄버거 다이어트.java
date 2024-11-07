import java.util.*;
import java.io.*;

public class Solution {
	
	static int limit;
	static int N;
	static int max;
	static int[][] info;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			limit = sc.nextInt();
			max = 0;
			//info[n][0]은 맛 점수, info[n][1]은 칼로리
			info = new int[N][2];
			for(int i=0; i<N; i++) {
				info[i][0] = sc.nextInt();
				info[i][1] = sc.nextInt();
			}
			

			dfs(0, 0, 0);

			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static void dfs(int material, int cal_sum, int point_sum) {
		
		if(cal_sum > limit) {
			return;
		}
		
		max = Math.max(point_sum, max);
		
		for(int i=material; i<N; i++) {
			dfs(i + 1, cal_sum+info[i][1], point_sum+info[i][0]);
		}
			
	}

}
