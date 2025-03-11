import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    // 정지, 상, 하, 좌, 우
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};
    static List<int[]> swirls;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            swirls = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==2){
                        swirls.add(new int[]{i, j});
                    }
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println("#" + test_case + " " + bfs(startX, startY, endX, endY));
        }
    }

    static int bfs(int x, int y, int endX, int endY){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0, 0});
        boolean[][] visited = new boolean[N][N];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentT = current[2];
            int stopCnt = current[3];

            if(currentX==endX && currentY==endY){
                return currentT;
            }

            if(currentT%3==2){
                disappearSwirl();
            } else{
                makeSwirl();
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N
                && dx[i]==0 && dy[i]==0 && stopCnt <= 3){
                    queue.offer(new int[]{nextX, nextY, currentT+1, stopCnt+1});
                } else if(nextX>=0 && nextX<N && nextY>=0 && nextY<N
                && !visited[nextX][nextY] && map[nextX][nextY]==0){
                    queue.offer(new int[]{nextX, nextY, currentT+1, 0});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    // dfs로 이동 했거나 안했거나를 가지뻗기
    static void simulate(int x, int y, int time, boolean[][] visited){
        if(time%3==2){
            // 소용돌이 사라짐
            disappearSwirl();
        } else{
            makeSwirl();
        }

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<N && nextY>=0 && nextY<N
            && !visited[nextX][nextY] && map[nextX][nextY]==0){
                visited[nextX][nextY] = true;
                simulate(nextX, nextY, time+1, visited);
                visited[nextX][nextY] = false;
            }
        }
    }

    static void makeSwirl(){
        for (int[] swirl : swirls) {
            int x = swirl[0];
            int y = swirl[1];

            map[x][y] = 2;
        }
    }

    static void disappearSwirl(){
        for (int[] swirl : swirls) {
            int x = swirl[0];
            int y = swirl[1];

            map[x][y] = 0;
        }
    }

}