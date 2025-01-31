import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int H;
    static int W;
    static int sx;
    static int sy;
    static int fx;
    static int fy;
    static boolean[][] visited;
    static int[][] map;
    static int[][] sum;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        sum = new int[N+1][M+1];
        visited = new boolean[N][M];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        H = sc.nextInt();
        W = sc.nextInt();
        sx = sc.nextInt()-1;
        sy = sc.nextInt()-1;
        fx = sc.nextInt()-1;
        fy = sc.nextInt()-1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = map[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        System.out.println(bfs(sx, sy));
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int count = current[2];

            if (currentX==fx && currentY==fy) {
                return count;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX>=0 && nextX+H<=N && nextY>=0 && nextY+W<=M
                && !visited[nextX][nextY] && isValid(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, count+1});
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        int total = sum[x+H][y+W] - sum[x][y+W] - sum[x+H][y] + sum[x][y];
        return total == 0;
    }
}
