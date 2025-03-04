import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int result;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[5][5];
        result = 0;
        
        for (int i = 0; i < 5; i++) {
            String token = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = token.charAt(j);
            }
        }

        comb(0, 0, new int[7]);
        
        System.out.println(result);
    }

    static void comb(int index, int depth, int[] sel){
        if(depth==7){
            if(checkIsValid(sel)){
                result++;
            };
            return;
        }

        if(index==25){
            return;
        }

        sel[depth] = index;
        comb(index+1, depth+1, sel);
        comb(index+1, depth, sel);
    }

    static boolean checkIsValid(int[] sel){
        boolean[][] pointSet = new boolean[5][5];
        for (int i = 0; i < pointSet.length; i++) {
            Arrays.fill(pointSet[i], true);
        }
        for (int i = 0; i < 7; i++) {
            int x = sel[i] / 5;
            int y = sel[i] % 5;
            pointSet[x][y] = false;
        }

        int startX = sel[0] / 5;
        int startY = sel[0] % 5;

        return bfs(startX, startY, pointSet);
    }

    static boolean bfs(int x, int y, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int sCnt = 0;
        int yCnt = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            if (map[currentX][currentY]=='S') {
                sCnt++;
            } else if(map[currentX][currentY]=='Y'){
                yCnt++;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextX<5 && nextY>=0 && nextY<5
                && !visited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        if(sCnt+yCnt==7 && sCnt>=4){
            return true;
        } else{
            return false;
        }
    }
}
