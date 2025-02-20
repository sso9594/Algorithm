import java.io.*;
import java.util.*;
import java.util.concurrent.Future;

public class Solution {
	// 우 하 좌 상 반복 = 포지션션
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {		
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];

			dfs(0, 0, 1, 0);

			System.out.println("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println("");
			}
		}
		
	}		

	static void dfs(int x, int y, int count, int position){

		visited[x][y] = true;
		arr[x][y] = count;

		int nextX = x + dx[position];
		int nextY = y + dy[position];

		if(nextX<0 || nextY<0 || nextX>=N 
		|| nextY>=N || visited[nextX][nextY]){
			position = (position + 1) % 4;
			nextX = x + dx[position];
			nextY = y + dy[position];
		}

		if(nextX>=0 && nextY>=0 && nextX<N && nextY<N
		&& !visited[nextX][nextY]){
			dfs(nextX, nextY, count+1, position);
		}
		
	}
}
