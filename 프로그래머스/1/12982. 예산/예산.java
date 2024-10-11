import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int num : d){
            if(budget-num>=0){
                budget -= num;
                answer++;
            }
        }
        return answer;
    }
}