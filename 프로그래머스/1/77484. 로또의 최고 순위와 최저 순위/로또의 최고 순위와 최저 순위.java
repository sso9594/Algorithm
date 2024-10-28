import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        for(int lottoNum : lottos){
            for(int target : win_nums){
                if(lottoNum==target) count++;
            }
            if(lottoNum == 0) zeroCount++;
        }

        int minRate = 7 - count;
        int maxRate = minRate - zeroCount;
        if(count < 1){
            minRate -= 1;
        }
        if(maxRate >6){
            maxRate = 6;
        }
        answer[0] = maxRate;
        answer[1] = minRate;
        return answer;
    }
}