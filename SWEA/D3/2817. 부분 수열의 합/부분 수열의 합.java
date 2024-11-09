import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int K;
	static int count;
	static int[] arr;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			count = 0;
			
			arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				dfs(i, 0);
			}
		
			
			System.out.println("#" + test_case + " " + count);
		}
	}
	
	static void dfs(int v, int sum) {
		
		sum += arr[v];
		
		if(sum == K) {
			count++;
			return;
		} else if(sum > K) {
			return;
		}
			
		for(int i=v+1; i<N; i++) {
			dfs(i, sum);
		}
	}

}
