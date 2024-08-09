import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int n,m,v = 0;
    static int[][] edge;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        edge = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edge[start][end] = 1;
            edge[end][start] = 1;
        }

        dfs(v);

        visited = new boolean[n+1];

        sb.append("\n");
        
        bfs(v);

        System.out.println(sb);

    }

    static void dfs(int x){
        visited[x] = true;
        sb.append(x + " ");
        for(int j=1; j<=n; j++){
            if(!visited[j] && edge[x][j]==1){
                dfs(j);
            }
        }

    }

    static void bfs(int x){
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp + " ");
            for(int k=1; k<=n; k++){
                if(edge[temp][k] == 1 && !visited[k]){
                    queue.add(k);
                    visited[k] = true;
                }
            }
        }
    }
}
