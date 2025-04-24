import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    
    int bfs(int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cCnt = cur[2];
            if(cx == maps.length-1 && cy == maps[0].length-1){
                return cCnt;
            }
            for(int i=0; i<dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length
                  && !visited[nx][ny] && maps[nx][ny] == 1){
                    queue.offer(new int[]{nx, ny, cCnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}