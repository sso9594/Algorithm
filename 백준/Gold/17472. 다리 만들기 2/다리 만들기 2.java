import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 넘버링
        int number = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    bfs(i,j,number++);
                }
            }
        }

        // 인접행렬 구하기 (다리 연결)
        adj = new int[number-2][number-2];
        for (int i = 0; i < adj.length; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>0){
                    getAdj(i,j);
                }
            }
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                if(adj[i][j]==Integer.MAX_VALUE) adj[i][j]=0;
            }
        }

        // MST(Prim)
        int[] dist = new int[number-2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] visited = new boolean[number-2];

        int answer = 0;

        // 각 정점 순회
        for (int step = 0; step < number-2; step++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < number-2; i++) {
                if(!visited[i] && dist[i] < min){
                    min = dist[i];
                    idx = i;
                }
            }

            if(idx==-1){
                System.out.println(-1);
                return;
            }

            visited[idx] = true;
            answer += dist[idx];

            for (int i = 0; i < number-2; i++) {
                if(!visited[i] && adj[idx][i]!=0 && adj[idx][i] < dist[i]){
                    dist[i] = adj[idx][i];
                }
            }
        }
        
        System.out.println(answer);
    }

    static void getAdj(int x, int y) {
        int start = map[x][y]-2;
        int end = -1;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int count = 0;
            while (nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==0) {
                nx += dx[i];
                ny += dy[i];
                count++;
                if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]!=map[x][y]
                && map[nx][ny]>1){
                    end = map[nx][ny]-2;
                    if(adj[start][end]>count && count>1){
                        adj[start][end] = count;
                        adj[end][start] = count;
                    }
                }
            }
        }
    }

    static void bfs(int i, int j, int number) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        boolean[][] visited = new boolean[N][M];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            map[cx][cy] = number;
            for (int k = 0; k < dx.length; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if(nx>=0 && ny>=0 && nx<N & ny<M && !visited[nx][ny]
                && map[nx][ny]==1){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}