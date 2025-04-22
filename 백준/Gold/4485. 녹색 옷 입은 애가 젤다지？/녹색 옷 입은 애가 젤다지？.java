import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int x, y, w;

        Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Main.Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = 0;
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

            System.out.println("Problem " + ++test_case +": "+ result);
        }
    }

    static int daijkstra(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, y, map[x][y]));
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[x][y] = map[x][y];

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
