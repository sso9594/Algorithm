import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] coins = new int[]{1, 2, 3};
        long[] dp = new long[max+1];
        dp[0] = 1L;

        for(int coin : coins){
            for (int i=coin; i<=max; i++){
                dp[i] += dp[i-coin];
            }
        }

        for (int i=0; i<N; i++){
            System.out.println(dp[arr[i]]);
        }
    }

    /**
     * 1: 1
     * 2: 1+1, 2
     * 3: 1+2, 1+1+1, 3
     * 4: 1+3, 1+1+2, 1+1+1+1, 2+2
     * 5: 1+1+3, 1+1+1+2, 1+1+1+1+1, 1+2+2, 2+3
     */
}
