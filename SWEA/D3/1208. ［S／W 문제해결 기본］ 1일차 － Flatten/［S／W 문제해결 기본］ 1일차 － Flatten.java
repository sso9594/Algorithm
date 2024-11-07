import java.util.*;
import java.io.*;

class Solution
{
    static int swap_count;
    static int max;
    static int test = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] ground = new int[100];
            for(int i=0; i<100; i++){
                ground[i] = sc.nextInt();
            }
            for(int i=0; i<N; i++){
                Arrays.sort(ground);
                ground[0]++;
                ground[99]--;
            }
            Arrays.sort(ground);
            int diff = ground[99] - ground[0];
            System.out.println("#" + test_case + " " + diff);

		}
	}
}