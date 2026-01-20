import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx = 0;
        
        while(left <= right){
            int i = (int)(left / (long)n);
            int j = (int)(left % (long)n);
            
            answer[idx++] = Math.max(i, j)+1;
            left++;
        }
        return answer;
    }
}