import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case=1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                String token = sc.next();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.charAt(j)+"");
                }
            }
            
            for (int i = 0; i < (N/2)+1; i++) {
                for (int j = (N/2)+1; j <= (N/2)+i; j++) {
                    sum += arr[i][j];
                }
                for (int j = (N/2); j >= (N/2)-i; j--) {
                    sum += arr[i][j];
                }
            }

            for (int i = N-1, k=0; i >= (N/2)+1; i--, k++) {
                for (int j = (N/2)+1; j <= (N/2)+k; j++) {
                    sum += arr[i][j];
                }
                for (int j = (N/2); j >= (N/2)-k; j--) {
                    sum += arr[i][j];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
	}
}