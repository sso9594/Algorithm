import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            queue.offer(scoville[i]);
        }
        
        while(queue.peek() < K){
            if(queue.size() < 2){
                answer = -1;
                break;
            }
            int min = queue.poll();
            int sec = queue.poll();
            
            int mix = min + (sec * 2);
            queue.offer(mix);
            answer++;
        }
        
        return answer;
    }
}