import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        int max = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int height=0; height<=100; height++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && arr[i][j] > height){
                        countArea(height, i, j);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static void countArea(int height, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            for(int i=0; i<4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]
                && arr[nextX][nextY] > height){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[] {nextX, nextY});
                }
            }
        }

    }

}
