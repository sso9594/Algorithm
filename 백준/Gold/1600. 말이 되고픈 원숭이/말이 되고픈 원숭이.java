import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W;
    static int H;
    static int min;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] dxHorse = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dyHorse = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        map = new int[W][H];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
        
        System.out.println(min==Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0, K});
        boolean[][][] visited = new boolean[W][H][K+1];
        visited[x][y][K] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int count = current[2];
            int horseCnt = current[3];
            if(currentX==W-1 && currentY==H-1){
                min = Math.min(min, count);
                continue;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextCnt = count+1;
                if(nextX>=0 && nextY>=0 && nextX<W && nextY<H && !visited[nextX][nextY][horseCnt]
                && map[nextX][nextY]!=1){
                    visited[nextX][nextY][horseCnt] = true;
                    queue.offer(new int[]{nextX, nextY, nextCnt, horseCnt});
                }
            }
            if(horseCnt>0){
                for (int i = 0; i < dxHorse.length; i++) {
                    int nextX = currentX + dxHorse[i];
                    int nextY = currentY + dyHorse[i];
                    int nextCnt = count + 1;        
                    if(nextX>=0 && nextY>=0 && nextX<W && nextY<H && !visited[nextX][nextY][horseCnt-1]
                    && map[nextX][nextY]!=1){
                        visited[nextX][nextY][horseCnt-1] = true;
                        queue.offer(new int[]{nextX, nextY, nextCnt, horseCnt-1});
                    }
                }
            }
        }
    }

}
