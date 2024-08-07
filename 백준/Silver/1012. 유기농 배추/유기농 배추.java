import java.io.*;
import java.util.*;

public class Main {

    static int m = 0;
    static int n = 0;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int r=0; r<t; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] location = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int loc1 = Integer.parseInt(st.nextToken());
                int loc2 = Integer.parseInt(st.nextToken());

                location[loc1][loc2] = 1;
            }

            int count = 0;

            for(int j=0; j<m; j++){
                for(int l=0; l<n; l++){
                    if(location[j][l] == 1 && !visited[j][l]){
                        dfs(j, l, visited, location);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y, boolean[][] visited, int[][] location){
        visited[x][y] = true;

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx>=0 && cy>=0 && cx < m && cy < n){
                if(!visited[cx][cy] && location[cx][cy] == 1){
                    dfs(cx, cy, visited, location);
                }
            }
        }
    }
}