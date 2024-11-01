import java.io.*;
import java.util.*;

public class Main {

    static int[][] edge;
    static boolean[] visited;
    static int count = 0;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edge = new int[N+1][N+1];
        visited = new boolean[N+1];
        visited[0] = true;

        for(int i=0; i<M; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            edge[Integer.parseInt(st1.nextToken())][Integer.parseInt(st1.nextToken())] = 1;
        }

        for(int i=1; i<=N; i++){
            visited[i] = false;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
        
    }

    static void dfs(int v){
        visited[v] = true;

        for(int i=1; i<=N; i++){
            if(edge[v][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
        for(int i=1; i<=N; i++){
            if(edge[i][v]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
