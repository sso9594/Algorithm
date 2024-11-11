import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String N = sc.next();
            int length = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            String[] arr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

            map.put("ZRO", 0);
            map.put("ONE", 0);
            map.put("TWO", 0);
            map.put("THR", 0);
            map.put("FOR", 0);
            map.put("FIV", 0);
            map.put("SIX", 0);
            map.put("SVN", 0);
            map.put("EGT", 0);
            map.put("NIN", 0);

            for(int i=0; i<length; i++){
                String token = sc.next();
                map.put(token, map.getOrDefault(token, 0)+1);
            }
            System.out.println("#" + test_case);

            for(String token : arr){
                int num = map.getOrDefault(token, 0);
                for(int i=0; i<num; i++){
                    System.out.print(token + " ");
                }
            }
            
		}
	}

}