import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] adjMat = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(adjMat[i], 100_000_000);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num > 0){
                        adjMat[i][j] = num;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                    }
                }
            }

            int result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if(i!=j){
                        sum += adjMat[i][j];
                    }
                }
                result = Math.min(result, sum);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}