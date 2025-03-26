import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int result;
    static class Point  {
        int e;

        Point(int e){
            this.e = e;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            result = 0;

            ArrayList<Point>[] adjMat = new ArrayList[101];
            for (int i = 0; i < 101; i++) {
                adjMat[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N/2; i++) {
                int v = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                Point point = new Point(e);
                adjMat[v].add(point);
            }

            bfs(adjMat, start);

            System.out.println("#" + test_case + " " + result);
            
        }
    }

    static void bfs(ArrayList<Point>[] adjMat, int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[101];
        visited[start] = true;

        int maxCnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curV = cur[0];
            int curCnt = cur[1];

            if(maxCnt == curCnt){
                result = Math.max(curV, result);
            } else if(maxCnt < curCnt){
                maxCnt = curCnt;
                result = curV;
            }

            if(adjMat[curV].size()>0){
                for (int i=0; i<adjMat[curV].size(); i++) {
                    int next = adjMat[curV].get(i).e;
                    if(!visited[next]){
                        queue.offer(new int[]{next, curCnt+1});
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
