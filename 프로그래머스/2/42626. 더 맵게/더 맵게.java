import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : scoville){
            queue.offer(num);
        }
        while(queue.peek()<K){
            int fLow = queue.poll();
            int sLow = queue.poll();
            int result = fLow + (sLow*2);
            queue.offer(result);
            answer++;
            if(queue.size()<=1) break;
        }
        if(queue.peek()<K){
            answer = -1;
        }
        return answer;
    }
}