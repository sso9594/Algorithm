class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] dp = new long[n][m];
        for(int[] puddle : puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == -1) dp[i][j] = 0;
                else if (i==0 && j==0) continue;
                else if(i==0) dp[i][j] = dp[i][j-1];
                else if(j==0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1_000_000_007L;
            }
        }
        answer = (int) dp[n-1][m-1];
        return answer;
    }
}