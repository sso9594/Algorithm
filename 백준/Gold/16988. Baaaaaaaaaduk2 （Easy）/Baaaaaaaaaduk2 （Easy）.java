import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] baduk;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        baduk = new int[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                baduk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0, new int[2]);

        System.out.println(result);
    }

    static void comb(int depth, int index, int[] sel){
        if(depth==2){
            // 탐색 로직
            int[][] cpy = new int[N][M];
            for (int i = 0; i < N; i++) {
                cpy[i] = Arrays.copyOf(baduk[i], M);
            }
            for (int i = 0; i < sel.length; i++) {
                int x = sel[i] / M;
                int y = sel[i] % M;
                if(cpy[x][y]==0){
                    cpy[x][y] = 1;
                }
            }
            boolean[][] visited = new boolean[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(cpy[i][j]==2 && !visited[i][j]){
                        count += bfs(i, j, cpy, visited);
                    }
                }
            }
            result = Math.max(result, count);
            return;
        }

        if(index == N*M){
            return;
        }


        sel[depth] = index;
        comb(depth+1, index+1, sel);
        comb(depth, index+1, sel);
    }

    static int bfs(int x, int y, int[][] baduk, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        boolean valid = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            count++;

            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M
                && baduk[nextX][nextY]==0){
                    valid = false;
                }
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M
                && !visited[nextX][nextY] && baduk[nextX][nextY]==2){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        if(valid) return count;
        return 0;
    }
}

/* 
    바둑돌을 두개 두고 (조합)
    둔 위치에 인접한 상대의 돌에 dfs로 몇개인지 탐색
    탐색 하는 도중에 사방탐색을 통해 한 면이라도 벽 or 내 돌 or 상대돌이 아니라면
    그 세트는 불가능
*/
