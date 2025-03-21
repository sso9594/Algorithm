import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(maxQ.isEmpty() && command.equals("D")) continue;
            if(command.equals("I")){
                maxQ.offer(num);
                minQ.offer(num);
            } else if(command.equals("D")){
                if(num==1){
                    minQ.remove(maxQ.poll());
                } else if(num==-1){
                    maxQ.remove(minQ.poll());
                }
            }
        }
        
        if(maxQ.isEmpty()) answer[0] = answer[1] = 0;
        else{
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();   
        }
        return answer;
    }
}