import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Vertex implements Comparable<Vertex>{
        int e, w;
        Vertex(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o){
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine())-1;

        ArrayList<Vertex>[] adjList = new ArrayList[V];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adjList[s].add(new Vertex(e, w));
        }

        // Dijkstra
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Vertex(K, 0));
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Vertex p = queue.poll();
            int minV = p.e;
            if(visited[minV]) continue;

            visited[minV] = true;

            for (Vertex target : adjList[minV]) {
                if(!visited[target.e] && dist[minV]+target.w < dist[target.e]){
                    dist[target.e] = dist[minV]+target.w;
                    queue.add(new Vertex(target.e, dist[target.e]));
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]==Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}
