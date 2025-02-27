import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        int[] memory = new int[N+1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            memory[i] = i-1;
            if(i%2==0 && dp[i/2] + 1 < dp[i]){
                dp[i] = dp[i/2] + 1;
                memory[i] = i/2;
            }
            if(i%3==0 && dp[i/3]+1 < dp[i]){
                dp[i] = dp[i/3] + 1;
                memory[i] = i/3;
            }
        }

        System.out.println(dp[N]);
        int index = N;
        System.out.print(N + " ");
        while (index>1) {
            System.out.print(memory[index] + " ");
            index = memory[index];
        }
    }
}
