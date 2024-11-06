import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		// int T;
		// T=sc.nextInt();
		
		int N = sc.nextInt();
		String tsn = "369";
				
		for(int i=1; i<=N; i++) {
			String token = ""+i;
			String str = "";
			for(int j=0; j<token.length(); j++) {
				if(tsn.contains(token.charAt(j)+"")) {
					for(int x=0; x<str.length(); x++) {
						if(str.charAt(x)!='-') {
							str = "";
						}
					}
					str += "-";
				} else if(!str.contains("-")) {
					str += token.charAt(j);
				}
			}
			System.out.print(str + " ");
		}
/*
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String tsn = "369";
			
			System.out.println("#" + test_case);
			
			for(int i=1; i<=N; i++) {
				String token = ""+i;
				System.out.println(token);
			}
			
		}
			*/
	}

}
