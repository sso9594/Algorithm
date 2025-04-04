import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}

		
	}
}

/*
 * dp[1] = 1
 * dp[2] = 2
 * dp[3] = 4
 * dp[4] = 7
 * dp[5] = dp[4] + dp[3] + dp[2]

 * dp[N] = 
 */