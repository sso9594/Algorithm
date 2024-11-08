import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int max = 0;
			int[][] table = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			int degak1 = 0;
			int degak2 = 0;
					
			for(int i=0; i<100; i++) {
				int temp_max1 = 0;
				int temp_max2 = 0;
				// 행 덧셈
				for(int j=0; j<100; j++) {
					temp_max1 += table[i][j];
				}
				// 열 덧셈
				for(int j=0; j<100; j++) {
					temp_max2 += table[j][i];
				}
				// 행 열 중 큰거 저장
				temp_max1 = Math.max(temp_max1, temp_max2);
				max = Math.max(temp_max1, max);
				// 대각 덧셈
				degak1 += table[i][i];
				degak2 += table[i][100-i-1];

			}
			
			max = Math.max(max, degak1);
			max = Math.max(max, degak2);
		
			
			System.out.println("#" + test_case + " " + max);
		}
	}

}
