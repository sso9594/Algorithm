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
			int A = sc.nextInt();
			int B = sc.nextInt();
			int N = sc.nextInt();
			
			int x = A;
			int y = B;
			int count = 0;
			
			while(x <= N && y <= N) {
				if(x<y) {
					x += y;
				} else {
					y += x;
				}
				count++;
			}
			
			
			System.out.println(count);
			
		}
	}
}
