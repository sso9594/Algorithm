import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            arr = rotation(arr);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] rotation(int[][] arr){
        int[][] arr_cpy = new int[N][M];
        for (int k = 0; k < Math.min(N, M)/2; k++) {
            // 위쪽
            for (int j = k; j < M-1-k; j++) {
                arr_cpy[k][j] = arr[k][j+1];
            }
            // 왼쪽
            for (int i = N-1-k; i > k; i--) {
                arr_cpy[i][k] = arr[i-1][k];
            }
            // 아래쪽
            for (int j = M-1-k; j > k; j--) {
                arr_cpy[N-1-k][j] = arr[N-1-k][j-1];
            }
            // 오른쪽
            for (int i = k; i < N-1-k; i++) {
                arr_cpy[i][M-1-k] = arr[i+1][M-1-k];
            }
        }

        return arr_cpy;
    }

}

/* M = 4, N = 4
 * 00 01 02 03       01 02 03 13
 * 10 11 12 13   ->  00 12 22 23
 * 20 21 22 23       10 11 21 33
 * 30 31 32 33       20 30 31 32
 * 
 * [M-N][M-N]   [M-N][M-N+1]   [M-N][M-N+2]   [M-N][M-N+3]        [M-N+1][M-N]   [M-N][M-N]     [M-N][M-N+1]   [M-N][M-N+2]
 * [M-N+1][M-N] [M-N+1][M-N+1] [M-N+1][M-N+2] [M-N+1][M-N+3]      [M-N+2][M-N]   [M-N+2][M-N+1] [M-N+1][M-N+1] [M-N][M-N+3]
 * [M-N+2][M-N] [M-N+2][M-N+1] [M-N+2][M-N+2] [M-N+2][M-N+3]      [M-N+3][M-N]   [M-N+2][M-N+2] [M-N+1][M-N+2] [M-N+1][M-N+3]                
 * [M-N+3][M-N] [M-N+3][M-N+1] [M-N+3][M-N+2] [M-N+3][M-N+3]      [M-N+3][M-N+1] [M-N+3][M-N+2] [M-N+3][M-N+3] [M-N+2][M-N+3]
 */