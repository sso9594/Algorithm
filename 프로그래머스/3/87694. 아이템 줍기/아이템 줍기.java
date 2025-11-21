import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int[] square : rectangle){
            int sx = square[0] * 2;
            int sy = square[1] * 2;
            int ex = square[2] * 2;
            int ey = square[3] * 2;
            
            // 가로 색칠
            for(int i=sx; i<=ex; i++){
                map[sy][i] = 1;
                map[ey][i] = 1;
            }
            // 세로 색칠
            for(int i=sy; i<=ey; i++){
                map[i][sx] = 1;
                map[i][ex] = 1;
            }
            
        }
        
        // 내부 비우기
        for(int[] square : rectangle){
            int sx = square[0] * 2;
            int sy = square[1] * 2;
            int ex = square[2] * 2;
            int ey = square[3] * 2;
            
            for(int i=sy+1; i<ey; i++){
                for(int j=sx+1; j<ex; j++){
                    map[i][j] = 0;
                }
            }
            
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        boolean[][] visited = new boolean[101][101];
        visited[characterY * 2][characterX * 2] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
                        
            if(cx==itemX*2 && cy==itemY*2){
                answer = cur[2]/2;
                break;
            }
            
            for(int i=0; i<dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx>=0 && nx<101 && ny>=0 && ny<101 && map[ny][nx]==1 && !visited[ny][nx]){
                    queue.offer(new int[]{nx,ny,cur[2]+1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return answer;
    }
}