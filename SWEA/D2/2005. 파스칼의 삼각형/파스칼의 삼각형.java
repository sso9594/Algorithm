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
			int[][] pascal = new int [N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					if(i>=1 && i<=N && j>=1 && j<=N) {
						pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
					} else {
						pascal[i][j] = 1;
					}
				}
			}
			
			System.out.println("#" + test_case);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println("");
			}
			
		}
	}
}
