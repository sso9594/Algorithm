import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 물건 개수
            int K = Integer.parseInt(st.nextToken()); // 가방 최대 부피

            int[][] things = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                things[i][0] = Integer.parseInt(st.nextToken()); // 부피
                things[i][1] = Integer.parseInt(st.nextToken()); // 가치
            }

            int[][] dp = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= K; j++) {
                    if (things[i][0] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things[i][0]] + things[i][1]);
                    }
                }
            }

            System.out.println("#" + test_case + " " + dp[N][K]);
        }
    }
}
