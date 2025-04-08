import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] C = new int[N]; // LDS를 만족하는 가장 끝 원소값

        for (int i = 0; i < N; i++) {
            arr[i] = -Integer.parseInt(st.nextToken()); // 부호 반전하여 증가 수열로 전환
        }

        int size = 0;

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(C, 0, size, arr[i]);
            if (pos >= 0) continue; // 중복 허용 안하는 경우

            int temp = Math.abs(pos) - 1;
            C[temp] = arr[i];

            if (temp == size) ++size;
        }

        System.out.println(size);
        // // n^2 풀이
        // for (int i = 0; i < N; i++) {
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }   
        // int[] lis = new int[N];
        // int max = 0;

        // for (int i = 0; i < N; i++) {
        //     lis[i] = 1;
        //     for (int j = 0; j < i; j++) {
        //         if(arr[j]>arr[i] && lis[i]<lis[j]+1){
        //             lis[i] = lis[j]+1;
        //         }
        //     }
        //     max = Math.max(max, lis[i]);
        // }

        // System.out.println(max);
    }
}
