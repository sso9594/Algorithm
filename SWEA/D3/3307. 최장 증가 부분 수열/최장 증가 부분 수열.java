import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] c = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int size = 0;

            for (int i = 0; i < N; i++) {
                int pos = Arrays.binarySearch(c, 0, size, arr[i]);
                if(pos>=0) return;

                int temp = Math.abs(pos)-1;
                c[temp] = arr[i];

                if(temp==size) size++;
            }

            System.out.println("#" + test_case + " " + size);

            // // n^2 풀이
            // int N = Integer.parseInt(br.readLine());
            // int[] arr = new int[N];
            // int[] lis = new int[N];
            // StringTokenizer st = new StringTokenizer(br.readLine());
            // for (int i = 0; i < N; i++) {
            //     arr[i] = Integer.parseInt(st.nextToken());
            // }

            // int max = 0;

            // for (int i = 0; i < N; i++) {
            //     lis[i] = 1;
            //     for (int j = 0; j < i; j++) {
            //         if(arr[i] > arr[j] && lis[i] < lis[j]+1){
            //             lis[i] = lis[j] + 1;
            //         }
            //     }
            //     max = Math.max(max, lis[i]);
            // }
            // System.out.println("#" + test_case + " " + max);
        }
    }
}
