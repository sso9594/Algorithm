import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] += dp[i-1][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[N].length; i++) {
            max = Math.max(dp[N-1][i], max);
        }
        System.out.println(max);
    }
    
}