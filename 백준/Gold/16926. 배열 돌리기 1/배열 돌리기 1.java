import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R번 회전
        for (int r = 0; r < R; r++) {
            // 레이어를 기준으로 회전하기 위해 N과 M중 작은 수를 나누기 2
            for (int k = 0; k < Math.min(N/2, M/2); k++) {
                // 모서리 하나를 빈칸으로 만들기 위해 임시 저장
                int temp = arr[k][k];
                // 위쪽 회전
                for (int i = k; i < M-k-1; i++) {
                    arr[k][i] = arr[k][i+1];
                }
                // 오른쪽 회전
                for (int i = k; i < N-k-1; i++) {
                    arr[i][M-k-1] = arr[i+1][M-k-1];
                }
                // 아래쪽 회전
                for (int i = k; i < M-k-1; i++) {
                    arr[N-k-1][M-i-1] = arr[N-k-1][M-i-2];
                }
                // 왼쪽 회전
                for(int i = k; i < N-k-1; i++){
                    arr[N-i-1][k] = arr[N-i-2][k];
                }
                arr[k+1][k] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}