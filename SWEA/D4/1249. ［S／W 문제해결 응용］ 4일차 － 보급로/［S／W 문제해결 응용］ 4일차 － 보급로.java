import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Point implements Comparable<Point>{
        int x, y, w;
        Point(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Solution.Point o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String token = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.charAt(j)+"");
                }
            }
            
            System.out.println("#"+ test_case + " " + dijkstra());
        }
    }

    static int dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        ArrayList<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(0);
        pq.add(new Point(0, 0, map[0][0]));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<N&&
                !visited[nx][ny] && dist[cx][cy]+map[nx][ny] < dist[nx][ny]){
                    dist[nx][ny] = dist[cx][cy] + map[nx][ny];
                    pq.add(new Point(nx, ny, map[nx][ny]));
                }
            }
        }

        return dist[N-1][N-1];
    }

}