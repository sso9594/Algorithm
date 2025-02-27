import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;
    static int room;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            max = 0;
            room = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }

            System.out.println("#" +  test_case + " " + room + " " + max);

        }

    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1});
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int cnt = current[2];

            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && !visited[nextX][nextY]
                && map[nextX][nextY] - map[currentX][currentY] == 1){
                    queue.offer(new int[]{nextX, nextY, cnt+1});
                    visited[nextX][nextY] = true;
                    if(count < cnt+1){
                        count = cnt+1;
                    }
                }
            }
        }

        // max가 count 보다 작으면 max = count
        // max가 갱신되었으면 room은 무조건 바뀌고, max == count 이면 대소를 비교해야함
        if(max < count){
            max = count;
            room = map[x][y];
        } else if(max == count){
            room = Math.min(room, map[x][y]);
        }

        

    }
}
