import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 2; i < N+1; i++) {
			if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2] + 1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);

			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}

		System.out.println(dp[N]);
	}
}

/*
 * dp[3] = 1
 * dp[2] = 1
 * dp[1] = 1
 * 
 * dp[4] = Math.min(dp[3] + dp[1], dp[2] + dp[2]) = 2
 * dp[5] = Math.min(dp[4] + dp[1], dp[1] + dp[1] + dp[3]) = 3
	dp[n] 이 2로 나눠지면 비교 해보고 3으로 나눠지면 비교해보고 안되면 그냥 이전 값의 + 1
 */