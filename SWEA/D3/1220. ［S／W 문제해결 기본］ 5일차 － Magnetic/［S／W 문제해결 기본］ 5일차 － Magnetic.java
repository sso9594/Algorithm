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
			int[][] table = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			
			// 열을 단위로 체크 table[i][j] 위가 N극 아래가 S극, 1이 N극, 2가 S극
			// -> 열 맨 위부터 체크해서 1이 나오는 곳부터 아래부터 체크해서 2가 나오는 곳 까지 전부 교착상태
			for(int j=0; j<N; j++) {
				int start = 0;
				int end = 0;
				int pre = 0;
				for(int i=0; i<N; i++) {
					if(table[i][j]==1) {
						start = i;
						break;
					}
				}
				for(int i=N-1; i>=0; i--) {
					if(table[i][j]==2) {
						end = i;
						break;
					}
				}
				for(int i=start; i<=end; i++) { 
					if(table[i][j]==1 && pre!=1) {
						count++;
					}
					if(table[i][j]>0) pre = table[i][j];
				}
			}
			
			
			System.out.println("#" + test_case + " " + count);
		}
	}

}
