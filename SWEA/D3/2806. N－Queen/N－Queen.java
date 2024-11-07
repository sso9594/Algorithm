import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int count;
	static boolean[][] chess;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			count = 0;
			chess = new boolean[N][N];
			
			dfs(0);
			
			System.out.println("#" + test_case + " " + count);
			
		}
	}
	
	static void dfs(int row) {
		
		if(row==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSafe(row,i)) {
				chess[row][i] = true;
				dfs(row + 1);
				chess[row][i] = false;
			}

		}
	}
	
	static boolean isSafe(int row, int col) {
		for(int i=0; i<row; i++) {
			if(chess[i][col]) return false;
		}
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(chess[i][j]) return false;
		}
		for(int i=row-1, j=col+1; i>=0 && j<N; i--, j++) {
			if(chess[i][j]) return false;
		}
		return true;
	}

}
