import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String token = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.charAt(j)+"");
            }
        }

        int result = bfs(0,0);

        System.out.println(result);
    }
    static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0, 1});
        boolean[][][] visited = new boolean[N][M][2];
        visited[x][y][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int count = cur[2];
            int dist = cur[3];

            if(cx == N-1 && cy == M-1){
                return dist;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 일반 이동
                if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny][count]
                && map[nx][ny] == 0){
                    queue.offer(new int[]{nx, ny, count, dist+1});
                    visited[nx][ny][count] = true;
                }
                //벽 부수고 이동
                if(count < 1){
                    if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny][count+1]
                    && map[nx][ny] == 1){
                        queue.offer(new int[]{nx, ny, count+1, dist+1});
                        visited[nx][ny][count+1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
