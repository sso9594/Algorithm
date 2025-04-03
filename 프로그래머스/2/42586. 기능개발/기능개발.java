import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            queue.offer(progresses[i]);
        }
        int time = 1;
        int index = 0;
        while(!queue.isEmpty()){
            if(!queue.isEmpty() && queue.peek() + speeds[index]*time >= 100){
                int count = 0;
                while(!queue.isEmpty() && queue.peek() + speeds[index]*time >= 100){
                    queue.poll();
                    index++;
                    count++;
                }
                result.add(count);
            }
            time++;
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}