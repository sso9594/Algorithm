import java.io.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, pcCnt, result, maxConnected;
    static int[][] map;
    static List<Processor> processors;
    
    static class Processor {
        int x, y;
        boolean isEdge;
        public Processor(int x, int y, boolean isEdge) {
            this.x = x;
            this.y = y;
            this.isEdge = isEdge;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            processors = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            continue; // 가장자리 프로세서는 이미 연결됨
                        }
                        processors.add(new Processor(i, j, false));
                    }
                }
            }
            
            pcCnt = processors.size();
            result = Integer.MAX_VALUE;
            maxConnected = 0;
            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + result);
        }
    }
    
    static void dfs(int index, int connected, int length) {
        if (index == pcCnt) {
            if (connected > maxConnected || (connected == maxConnected && length < result)) {
                maxConnected = connected;
                result = length;
            }
            return;
        }
        
        Processor p = processors.get(index);
        
        for (int d = 0; d < 4; d++) {
            int x = p.x, y = p.y, count = 0;
            boolean canConnect = true;
            
            while (true) {
                x += dx[d];
                y += dy[d];
                
                if (x < 0 || y < 0 || x >= N || y >= N) break;
                if (map[x][y] == 1) {
                    canConnect = false;
                    break;
                }
                count++;
            }
            
            if (canConnect) {
                x = p.x;
                y = p.y;
                for (int i = 0; i < count; i++) {
                    x += dx[d];
                    y += dy[d];
                    map[x][y] = 1;
                }
                
                dfs(index + 1, connected + 1, length + count);
                
                x = p.x;
                y = p.y;
                for (int i = 0; i < count; i++) {
                    x += dx[d];
                    y += dy[d];
                    map[x][y] = 0;
                }
            }
        }
        
        dfs(index + 1, connected, length);
    }
}