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
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int [N][N];
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i+M-1 < N && j+M-1 < N) {
						int sum = 0;
						for(int x=i; x<=i+M-1; x++) {
							for(int y=j; y<=j+M-1; y++) {
								sum += arr[x][y];
							}
						}
						max = Math.max(sum, max);
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
			
		}
	}
}