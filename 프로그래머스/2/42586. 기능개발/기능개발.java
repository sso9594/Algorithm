import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int time = 0;
        int idx = 0;
        int cnt = 0;
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int ness = (int) Math.ceil((float)remain / (float)speeds[i]);
            if (i==0){
                cnt++;
                time = ness;
                continue;
            }
            
            if(time >= ness){
                cnt++;
            } else {
                answer.add(cnt);
                time = ness;
                cnt = 1;
            }
        }
        
        answer.add(cnt);
        
        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}