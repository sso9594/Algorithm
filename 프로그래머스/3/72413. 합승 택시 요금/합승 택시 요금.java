import java.util.*;

public class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 200_000_000;
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int min = INF;
        for (int k = 1; k <= n; k++) {
            int total = dist[s][k] + dist[k][a] + dist[k][b];
            min = Math.min(min, total);
        }

        return min;
    }
}
