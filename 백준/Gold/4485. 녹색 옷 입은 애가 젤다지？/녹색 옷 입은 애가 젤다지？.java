import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Node implements Comparable<Node>{
        int x, y, coin;
        Node(int x, int y, int coin){
            this.x = x;
            this.y = y;
            this.coin = coin;
        }

        @Override
        public int compareTo(Main.Node o) {
            return Integer.compare(o.coin, this.coin);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = daijkstra(0,0);

            System.out.println("Problem " + count++ + ": " + result);
        }
        
        
    }

    static int daijkstra(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, y, map[x][y]));
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[x][y];
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N && 
                dist[nx][ny] > dist[cx][cy] + map[nx][ny]){
                    dist[nx][ny] = dist[cx][cy] + map[nx][ny];
                    queue.offer(new Node(nx, ny, map[nx][ny]));
                }
            }
        }

        return dist[N-1][N-1];
    }
}