import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE; //방문되지 않은 노드의 거리를 MAX_VALUE로 초기화
    static int n,m;
    static List<Integer>[] graph; //edge 저장 용도
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 edge 저장을 위한 리스트 초기화
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        // edge 저장
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        // 최소값을 찾기 위해 MAX_VALUE로 초기화
        int minSum = INF;
        int resultUser = -1;

        for(int i=1; i<=n; i++){
            int currentSum = bfs(i);
            if(currentSum < minSum){
                minSum = currentSum;
                resultUser = i;
            }
        }

        System.out.println(resultUser);
    }

    static int bfs(int v){
        // 각 정점간의 거리를 위한 거리배열
        int[] distance = new int[n+1];
        // 최단거리를 구해야 하므로 무한대로 초기화, 아직 방문하지 않으면 INF
        Arrays.fill(distance, INF);
        // 시작노드의 거리는 0
        distance[v] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int current = queue.poll();
            // 현재 노드의 모든 이웃에 대해 반복(edge로 저장한 것)
            for(int neighbor : graph[current]){
                // 아직 노드가 방문되지 않은 경우
                if(distance[neighbor] == INF){
                    // 현재 노드까지의 거리 + 1 = 이웃 노드 까지의 거리
                    distance[neighbor] = distance[current] + 1;
                    // 이웃 노드를 큐에 추가해 다음 탐색에 포함되도록
                    queue.add(neighbor);
                }
            }
        }

        int sum=0;
        for(int i=1; i<=n; i++){
            if(i != v){
                sum += distance[i];
            }
        }

        return sum;
    }
}
