import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int cX = 0;
        int cY = 0;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            char cmd = dirs.charAt(i);
            
            int dir = -1;
            
            switch(cmd){
                case 'U':
                    dir = 0;
                    break;
                case 'D':
                    dir = 1;
                    break;
                case 'R':
                    dir = 3;
                    break;
                case 'L':
                    dir = 2;
                    break;
                default:
                    break;
            }
            
            int nX = cX + dx[dir];
            int nY = cY + dy[dir];
            
            if(nX >= -5 && nX <= 5 && nY >= -5 && nY <= 5){
                String line1 = cX + "" + cY + "" + nX + "" + nY;
                String line2 = nX + "" + nY + "" + cX + "" + cY;
                
                set.add(line1);
                set.add(line2);
                
                cX = nX;
                cY = nY;
            }
            
        }
        
        answer = set.size() / 2;
        
        return answer;
    }
}