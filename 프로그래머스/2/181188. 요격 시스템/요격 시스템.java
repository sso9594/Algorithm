import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int prefix = targets[0][1];
        for(int i=1; i<targets.length; i++){
            if(prefix <= targets[i][0]){
                answer++;
                prefix = targets[i][1];
            }        
        }
        answer++;
        return answer;
    }
}