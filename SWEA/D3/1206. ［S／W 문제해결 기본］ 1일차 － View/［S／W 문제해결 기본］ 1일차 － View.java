import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] apt = new int[N];
            for(int i=0; i<N; i++){
                apt[i] = sc.nextInt();
            }

            int sum = 0;

            for(int i=2; i<N-2; i++){
                int l_diff = Math.min(apt[i] - apt[i-1], apt[i] - apt[i-2]);
                int r_diff = Math.min(apt[i] - apt[i+1], apt[i] - apt[i+2]);

                int diff = Math.min(l_diff, r_diff);
                if(diff>0){
                    sum += diff;
                }
            }

            System.out.println("#" + test_case + " " + sum);
		}
	}
}