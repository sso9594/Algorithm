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
			int A_hour = sc.nextInt();
			int A_min = sc.nextInt();
			int B_hour = sc.nextInt();
			int B_min = sc.nextInt();
			
			int result_hour = A_hour + B_hour;
			int result_min = B_min + A_min;
			if(result_min >= 60) {
				result_hour++;
				result_min -= 60;
			}
			if(result_hour > 12) {
				result_hour -= 12;
			}
			
			System.out.println("#" + test_case + " " + result_hour + 
					" " + result_min);
			
		}
	}
}
