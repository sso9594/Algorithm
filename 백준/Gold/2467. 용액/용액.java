import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = arr.length-1;
        long min = Long.MAX_VALUE;

        long[] answer = new long[2];

        while(left < right){
            long sum = arr[left] + arr[right];
            if(Math.abs(sum) <= min){
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if(sum < 0){
                left++;
            } else if(sum > 0){
                right--;
            } else {
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
