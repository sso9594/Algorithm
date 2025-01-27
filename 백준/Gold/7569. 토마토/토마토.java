import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static int[][][] day;
    static int[][][] arr;
    static Queue<int[]> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        int max = 0;

        arr = new int[H][N][M];
        day = new int[H][N][M];
        queue = new LinkedList<>();

        for (int p = 0; p < H; p++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[p][i][j] = sc.nextInt();
                    if(arr[p][i][j]==0){
                        day[p][i][j] = -1;
                    } else if(arr[p][i][j] == 1){
                        queue.offer(new int[]{p, i, j});
                    }
                }
            }
        }

        bfs();

        for (int p = 0; p < H; p++) {
            boolean valid = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(day[p][i][j] == -1){
                        max = -1;
                        valid = false;
                        break;
                    } else{
                        max = Math.max(max, day[p][i][j]);
                    }
                }
                if(!valid) break;
            }
            if(!valid) break;
        }

        System.out.println(max);
               
    }

    static void bfs(){

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentH = current[0];
            int currentX = current[1];
            int currentY = current[2];
            for (int k = 0; k < dx.length; k++) {
                int nextH = currentH + dh[k];
                int nextX = currentX + dx[k];
                int nextY = currentY + dy[k];
                if(nextH >=0 && nextX>=0 && nextY>=0 && nextH < H && nextX<N
                && nextY<M && arr[nextH][nextX][nextY]==0 && day[nextH][nextX][nextY]<1){
                    day[nextH][nextX][nextY] = day[currentH][currentX][currentY] + 1;
                    queue.offer(new int[]{nextH, nextX, nextY});
                }

            }
        }
    }
}
