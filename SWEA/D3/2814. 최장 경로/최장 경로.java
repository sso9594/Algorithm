import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int M;
	static int[][] edge;
	static boolean[] visited;
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			max = 0;
			edge = new int[N+1][N+1];
			visited = new boolean[N+1];
			visited[0] = true;
			
			for(int i=0; i<M; i++) {
				edge[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				dfs(i, 1);
			}
			
			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static void dfs(int node, int depth) {

		visited[node] = true;
		max = Math.max(depth, max);
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && (edge[node][i]==1 || edge[i][node]==1)) {
				dfs(i, depth+1);
			}
		}
		visited[node] = false;
	}

}
