import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int K;
    static int[][] map;
    static Set<Peak> maxSet;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int result;
    static class Peak {
        int x, y, h;
        Peak(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            int max = 0;
            result = 0;
            maxSet = new HashSet<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == max){
                        maxSet.add(new Peak(i, j, max));
                    }
                }
            }

            for (Peak peak : maxSet) {
                boolean[][] visited = new boolean[N][N];
                visited[peak.x][peak.y] = true;
                dfs(peak.x, peak.y, 1, true, visited);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void dfs(int x, int y, int count, boolean valid, boolean[][] visited){

        result = Math.max(result, count);

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX<N && nextY<N && nextX>=0 && nextY>=0 &&
            (map[x][y] > map[nextX][nextY]) && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, count+1, valid, visited);
                visited[nextX][nextY] = false;
            } else if(nextX<N && nextY<N && nextX>=0 && nextY>=0 &&
            (map[x][y] <= map[nextX][nextY]) && valid && !visited[nextX][nextY]){
                for (int j = 1; j <= K; j++) {
                    breakWall(nextX, nextY, j);
                    if(map[x][y] > map[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        dfs(nextX, nextY, count+1, false, visited);
                        visited[nextX][nextY] = false;
                    }
                    restoreWall(nextX, nextY, j);    
                }                
            }
        }
    }

    static void breakWall(int x, int y, int power){
        map[x][y] -= power;
    }

    static void restoreWall(int x, int y, int power){
        map[x][y] += power;
    }
}