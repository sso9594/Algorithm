import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        
        for(String op : operations){
            String[] commands = op.split(" ");
            String command = commands[0];
            int num = Integer.parseInt(commands[1]);
            
            if(command.equals("I")){
                maxq.offer(num);
                minq.offer(num);
            } else if(command.equals("D")){
                if(num == 1){
                    if(!maxq.isEmpty()){
                        minq.remove(maxq.poll());
                    }
                } else if(num == -1){
                    if(!minq.isEmpty()){
                        maxq.remove(minq.poll());    
                    }
                }
            }
        }
        
        if(maxq.isEmpty() && minq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
            
            return answer;
        }
        
        answer[0] = maxq.poll();
        answer[1] = minq.poll();
        
        return answer;
    }
}