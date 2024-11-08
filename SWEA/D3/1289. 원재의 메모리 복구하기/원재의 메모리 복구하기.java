import java.util.*;
import java.io.*;

class Solution
{
    // 바뀌는 횟수+1
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String N = sc.next();
            int count;
            if(N.charAt(0)=='0') {
                count = 0;
            } else{
                count = 1;
            }

            for(int i=0; i<N.length()-1; i++){
                if(N.charAt(i)!=N.charAt(i+1)) count++;
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}