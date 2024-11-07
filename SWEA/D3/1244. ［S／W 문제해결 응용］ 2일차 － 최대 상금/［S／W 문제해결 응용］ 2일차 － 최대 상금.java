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
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            Set<String> visited = new HashSet<>();
            String N = sc.next();
            max = 0;
            swap_count = sc.nextInt();
            dfs(swap_count, N.toCharArray(), visited);

            System.out.println("#" + test_case + " " + max);
		}
	}

    static void dfs(int count, char[] arr, Set<String> visited){
        String save = new String(arr) + count;
        if(visited.contains(save)){
            return; 
        }
        visited.add(save);

        if(count==0){
            max = Math.max(max, Integer.parseInt(new String(arr)));
            return;
        }

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                swap(arr, i, j);
                dfs(count-1, arr, visited);
                swap(arr, i, j);
            }
        }
    }

    static void swap(char[] arr, int i, int j){
        char temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}