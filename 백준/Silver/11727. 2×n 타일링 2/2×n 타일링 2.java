import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 9;
        for(int i=4; i<=n; i++){
            dp[i] = ((2 * dp[i-2]) + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
