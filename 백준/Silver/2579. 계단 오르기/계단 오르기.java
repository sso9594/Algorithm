import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> stair = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            stair.add(Integer.parseInt(br.readLine()));
        }
        if(n==1){
            System.out.println(stair.get(0));
            return;
        }
        if(n==2){
            System.out.println(stair.get(0) + stair.get(1));    
            return;
        }

        int[][] dp = new int[2][n+1];
        dp[0][1] = stair.get(0);
        dp[1][2] = stair.get(1);
        dp[0][2] = stair.get(0) + stair.get(1);
        for(int i=3; i<=n; i++){
            dp[0][i] = dp[1][i-1] + stair.get(i-1);
            dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + stair.get(i-1);
        }

        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}
