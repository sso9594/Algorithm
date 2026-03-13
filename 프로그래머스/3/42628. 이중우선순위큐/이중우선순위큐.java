import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for(String operation : operations){
            String[] ops = operation.split(" ");
            String op = ops[0];
            int num = Integer.parseInt(ops[1]);
            
            switch(op){
                case "I":
                    maxq.offer(num);
                    minq.offer(num);
                    break;
                case "D":
                    if(num == -1){
                        if(!minq.isEmpty()){
                            int min = minq.poll();
                            maxq.remove(min);
                        }
                    } else{
                        if(!maxq.isEmpty()){
                            int max = maxq.poll();
                            minq.remove(max);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        if(maxq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[0] = maxq.peek();
        answer[1] = minq.peek();
        return answer;
    }
}