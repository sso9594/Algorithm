import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] land) {
        int answer = 0;
        int[] colOil = new int[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int j=0; j<land[0].length; j++){
            int count = 0;
            for(int i=0; i<land.length; i++){
                if(!visited[i][j] && land[i][j]==1){
                    bfs(land, visited, i, j, colOil);
                }
            }
        }
        for(int i=0; i<colOil.length; i++){
            answer = Math.max(answer, colOil[i]);
        }
        return answer;
    }
    
    void bfs(int[][] land, boolean[][] visited, int x, int y, int[] colOil){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            set.add(cy);
            count++;
            for(int i=0; i<dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<land.length && ny<land[0].length
                  && !visited[nx][ny] && land[nx][ny]==1){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        for(int num : set){
            colOil[num] += count;
        }
        
    }
}

