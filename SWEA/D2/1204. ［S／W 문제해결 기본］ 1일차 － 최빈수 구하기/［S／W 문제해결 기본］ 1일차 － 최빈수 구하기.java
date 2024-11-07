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
            int N = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<1000; i++){
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            int max = 0;
            int max_index = 0;
            for(Map.Entry<Integer, Integer> set : map.entrySet()){
                if(max <= set.getValue()){
                    if(max == set.getValue()){
                        if(max_index < set.getKey()){
                            max = set.getValue();
                            max_index = set.getKey();
                        }
                    } else{
                        max = set.getValue();
                        max_index = set.getKey();
                    }
                }
            }
            System.out.println("#" + N + " " + max_index);
		}
	}
}