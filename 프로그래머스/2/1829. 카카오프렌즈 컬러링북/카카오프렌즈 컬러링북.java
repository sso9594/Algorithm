import java.util.*;

class Solution {
    
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    bfs(i, j, m, n, picture);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    void bfs(int x, int y, int m, int n, int[][] picture){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            count++;
            
            for(int i=0; i<dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx>=0 && ny>=0 && nx<m && ny<n
                  && !visited[nx][ny] 
                   && picture[x][y] == picture[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
    }
}