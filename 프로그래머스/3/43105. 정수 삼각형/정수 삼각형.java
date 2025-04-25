class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length+1][triangle.length+1];
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j] = triangle[i][j];
            }
        }

        for(int i=1; i<dp.length; i++){
            dp[i][0] += dp[i-1][0];
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        for(int i=0; i<dp[dp.length-1].length;i++){
            answer = Math.max(dp[dp.length-1][i], answer);
        }
        return answer;
    }
}