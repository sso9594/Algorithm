import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            int sum = 0;
            for(int i=0; i<N; i++){
                String token = sc.next();
                for(int j=0; j<N; j++){
                    farm[i][j] = Integer.parseInt(token.charAt(j)+"");
                }
            }

            // 위
            for(int i=0; i<N/2; i++){
                // 행 오른쪽
                for(int j=N/2+1; j<=N/2+i; j++){
                     sum += farm[i][j];
                }
                // 행 왼쪽
                for(int j=N/2; j>=N/2-i; j--){
                    sum += farm[i][j];
                }
            }

            int end = N;
            // 아래 N=5일때 i=2 부터 시작
            for(int i=N/2, k=0; i<N; i++, k++){
                // 행 오른쪽
                for(int j=N/2; j<N-k; j++){
                    sum += farm[i][j];
                }
               // 행 왼쪽
                for(int j=k; j<N/2; j++){
                   sum += farm[i][j];
                }
            }
            
            System.out.println("#" + test_case + " " + sum);

		}
	}
}