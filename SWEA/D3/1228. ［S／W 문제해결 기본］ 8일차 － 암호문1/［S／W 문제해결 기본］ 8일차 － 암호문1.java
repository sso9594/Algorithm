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
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0; i<N; i++){
                arr.add(sc.nextInt());
            }
            int command_count = sc.nextInt();
            for(int i=0; i<command_count; i++){
                String command = sc.next();
                int position = sc.nextInt();
                int insert_count = sc.nextInt();
                int[] new_arr = new int[insert_count];
                for(int j=0; j<insert_count; j++){
                    new_arr[j] = sc.nextInt();
                }
                for(int j=new_arr.length-1; j>=0; j--){
                    arr.add(position, new_arr[j]);
                }
            }

            System.out.print("#" + test_case + " ");
            for(int i=0; i<10; i++){
                System.out.print(arr.get(i) + " ");
            }
            System.out.println("");
            
		}
	}

}