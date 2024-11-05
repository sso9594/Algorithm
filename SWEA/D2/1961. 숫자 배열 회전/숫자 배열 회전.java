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
			int[][] arr = new int [N][N];
			int[][] arr_90 = new int [N][N];
			int[][] arr_180 = new int [N][N];
			int[][] arr_270 = new int [N][N];
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					arr_90[i][j] = arr[N-j-1][i];
				}
			}
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					arr_180[i][j] = arr_90[N-j-1][i];
				}
			}
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					arr_270[i][j] = arr_180[N-j-1][i];
				}
			}
			
			System.out.println("#" + test_case);

			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr_90[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr_180[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr_270[i][j]);
				}
				System.out.println("");
			}

		}
	}
}
