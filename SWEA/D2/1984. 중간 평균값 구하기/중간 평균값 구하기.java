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
            ArrayList<Integer> arr = new ArrayList<>();
            int max = 0;
            int max_index = 0;
            int min_index = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<10; i++){
                arr.add(sc.nextInt());
                if(max < arr.get(i)){
                    max = arr.get(i);
                    max_index = i;
                }
                if(min > arr.get(i)){
                    min = arr.get(i);
                    min_index = i;
                }
            }
            
            if(min_index < max_index){
                arr.remove(max_index);
                arr.remove(min_index);
            } else{
                arr.remove(min_index);
                arr.remove(max_index);
            }

            double sum = 0;
            for(int num : arr){
                sum += (double)num;
            }

            System.out.println("#" + test_case + " " + (int)Math.round(sum/(double)arr.size()));

		}
	}
}