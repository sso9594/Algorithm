import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static int result;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Node implements Comparable<Node>{
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Solution.Node o) {
            return Integer.compare(this.time, o.time);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                String token = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.charAt(j)+"");
                }
            }

            bfs(0,0);

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, map[x][y]));
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);    
        }
        
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N && dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]){
                    dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
                    pq.offer(new Node(nx, ny, map[nx][ny]));
                }
            }
        }

        result = dist[N-1][N-1];
    }
}