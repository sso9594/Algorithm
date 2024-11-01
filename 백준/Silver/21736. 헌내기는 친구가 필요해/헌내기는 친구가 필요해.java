import java.io.*;
import java.util.*;

public class Main {
    static char[][] campus;
    static boolean[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 0;
        
        campus = new char[N][M];
        visited = new boolean[N][M];
        int[][] locate = new int[1][2];

        for(int i=0; i<N; i++){
            String token = br.readLine();
            for(int j=0; j<M; j++){
                char target = token.charAt(j);
                campus[i][j] = target;
                if(target=='I'){
                    locate[0][0] = i;
                    locate[0][1] = j;
                }
            }
        }

        dfs(locate[0][0], locate[0][1]);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(campus[i][j]=='P' && visited[i][j]){
                    count++;
                }
            }
        }
        if(count>0){
            System.out.println(count);
        } else{
            System.out.println("TT");
        }
    }
    static void dfs(int x, int y){
        if(campus[x][y]!='X' && !visited[x][y]){
            visited[x][y] = true;
        } else{
            return;
        }
        if(x > 0 && !visited[x-1][y]){
            dfs(x-1,y);
        } 
        if(x < N-1 && !visited[x+1][y]){
            dfs(x+1,y);
        } 
        if(y > 0 && !visited[x][y-1]){
            dfs(x,y-1);
        } 
        if(y < M-1 && !visited[x][y+1]){
            dfs(x,y+1);
        }
    }
}
