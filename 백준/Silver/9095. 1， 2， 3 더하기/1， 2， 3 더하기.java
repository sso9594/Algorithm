import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> testCase = new ArrayList<>();

        for(int i=0; i<T; i++){
            testCase.add(Integer.parseInt(br.readLine()));
        }

        for(int test : testCase){
            System.out.println(dp(test));
        }
    }

    static int dp(int num){
        int[] dp = new int[num+4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        if(num<4) return dp[num];
        for(int i=4; i<=num; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[num];
    }

    /*
     * dp[0] = 0
     * dp[1] = 1 (1까지 합 방법의 갯수)
     * dp[2] = 1+1, 2 = 2
     * dp[3] = 1+1+1, 1+2, 2+1, 3 = 4
     * dp[4] = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 = 7
     * dp[5] = 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 2+2+1, 2+1+2, 1+2+2, 3+1+1, 1+3+1, 1+1+3
     *         2+3, 3+2 = 13
     * if(i>=4)
     *     dp[i] = dp[i-1] + dp[i-1] + dp[i-3];
     * 
     */
}
