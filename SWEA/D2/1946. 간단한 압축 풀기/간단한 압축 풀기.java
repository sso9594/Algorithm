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
			String str = "";
			for(int i=0; i<N; i++) {
				String token = sc.next();
				int num = sc.nextInt();
				for(int j=0; j<num; j++) {
					str += token;
				}
			}			
			
			System.out.println("#" + test_case);
			for(int i=1; i<=str.length(); i++) {
				System.out.print(str.charAt(i-1));
				if(i%10==0) System.out.println("");
			}
			System.out.println("");
		}
	}
}
