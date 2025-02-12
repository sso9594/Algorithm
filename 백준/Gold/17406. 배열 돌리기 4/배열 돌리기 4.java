import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int N;
    static int M;
    static Set<int[]> permuSet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int min = Integer.MAX_VALUE;
        int[][] arr = new int[N][M];
        int[][] rotate = new int[K][3];
        permuSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permu(new int[K], 0, 0, new boolean[K]);

        for (int[] set : permuSet) {
            int[][] cpy = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    cpy[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < K; i++) {
                cpy = rotateArr(cpy, rotate[set[i]][0], rotate[set[i]][1], rotate[set[i]][2]);
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += cpy[i][j];
                }
                min = Math.min(sum, min);
            }
        }
        
        System.out.println(min);
    }

    static int[][] rotateArr(int[][] cpy, int r, int c, int s) {
        int startX = r - s - 1;
        int startY = c - s - 1;
        int endX = r + s - 1;
        int endY = c + s - 1;

        for (int k = 0; k < Math.min(endX-startX+1,endY-startY+1)/2; k++) {
            int temp = cpy[startX + k][startY + k];  
            // v
            for (int x = startX + k; x < endX - k; x++) {
                cpy[x][startY + k] = cpy[x + 1][startY + k];
            }

            // <-
            for (int y = startY + k; y < endY - k; y++) {
                cpy[endX - k][y] = cpy[endX - k][y + 1];
            }

            // ^
            for (int x = endX - k; x > startX + k; x--) {
                cpy[x][endY - k] = cpy[x - 1][endY - k];
            }

            // ->
            for (int y = endY - k; y > startY + k + 1; y--) {
                cpy[startX + k][y] = cpy[startX + k][y - 1];
            }
            cpy[startX + k][startY + k + 1] = temp;
        }

        return cpy;

    }

    static void permu(int[] sel, int index, int depth, boolean[] visited){
        if(depth == K){
            permuSet.add(Arrays.copyOf(sel, depth));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                sel[index] = i;
                visited[i] = true;
                permu(sel, index+1, depth+1, visited);
                visited[i] = false;
            }
        }

    }
}
