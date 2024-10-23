import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        Arrays.sort(score);
        
        for(int i=1; i<=score.length; i++){
            if(i%m==0){
                answer += score[score.length-i] * m;
            }
        }
        return answer;
    }
}