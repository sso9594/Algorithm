import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num] = arr[num-1] + 1;
                if(result < arr[num]){
                    result = arr[num];
                }
            }
            System.out.println("#" + test_case + " " + (N-result));
        }
    }
 
}

/*
 * [ ,1 ,1 , 2 ,1 , , 1]
 * 
 */