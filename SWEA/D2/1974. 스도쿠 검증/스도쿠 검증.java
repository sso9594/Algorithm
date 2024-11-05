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
			int[][] sudoku = new int[9][9];
			boolean valid = true;
			int answer = 0;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			//가로 체크
			for(int i=0; i<9; i++) {
				Set<Integer> check = new HashSet<>();
				for(int j=0; j<9; j++) {
					check.add(sudoku[i][j]);
				}
				if(check.size()!=9) valid = false;
			}
			
			//세로 체크
			for(int i=0; i<9; i++) {
				Set<Integer> check = new HashSet<>();
				for(int j=0; j<9; j++) {
					check.add(sudoku[j][i]);
				}
				if(check.size()!=9) valid = false;
			}
			
			//3X3 체크
			for(int i=0; i<9; i+=3) {			
				for(int j=0; j<9; j+=3) {
					Set<Integer> check = new HashSet<>();
					for(int x=i; x<i+3; x++) {
						for(int y=j; y<j+3; y++) {
							check.add(sudoku[x][y]);
						}
					}	
					if(check.size()!=9) valid = false;
				}		
			}
			if(valid) answer = 1;
			else answer = 0;
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}