import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> honor = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(honor.size()<k){
                honor.add(score[i]);
            }else if(honor.get(0)<score[i]){
                honor.set(0, score[i]);
            }
            Collections.sort(honor);
            answer[i] = honor.get(0);
        }
        
        return answer;
    }
}