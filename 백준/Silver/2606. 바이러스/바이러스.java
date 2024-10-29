import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edgeN = Integer.parseInt(br.readLine());
        int count = 0;

        int[][] edge = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        visited[0] = false;

        for(int i=0; i<edgeN; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            edge[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        dfs(edge, 1, visited);

        for(boolean unhealth : visited){
            if(unhealth){
                count++;
            }
        }
        
        System.out.println(count-1);
    }

    static void dfs(int[][] edge, int vertex, boolean[] visited){
        visited[vertex] = true;

        for(int i=1; i<edge.length; i++){
            if(edge[vertex][i]==1 && !visited[i]){
                dfs(edge, i, visited);
            } else if(edge[i][vertex]==1 && !visited[i]){
                dfs(edge, i, visited);
            }
        }
    }
}
