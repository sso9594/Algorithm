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
			int oman = 0, man = 0, ochun = 0, chun = 0, obaek = 0, baek = 0, osip = 0, sip = 0;
			
			if(N/50000>0) {
				oman = N / 50000;
				N %= 50000;
			}
			if(N/10000>0) {
				man = N / 10000;
				N %= 10000;
			}
			if(N/5000>0) {
				ochun = N / 5000;
				N %= 5000;
			}
			if(N/1000>0) {
				chun = N / 1000;
				N %= 1000;
			}
			if(N/500>0) {
				obaek = N / 500;
				N %= 500;
			}
			if(N/100>0) {
				baek = N / 100;
				N %= 100;
			}
			if(N/50>0) {
				osip = N / 50;
				N %= 50;
			}
			if(N/10>0) {
				sip = N / 10;
				N %= 10;
			}

			
			System.out.println("#" + test_case);
			System.out.println(oman + " " + man + " " + ochun + " " + chun + " " + obaek + " " + baek + " " + osip + " " + sip);
			
		}
	}
}
