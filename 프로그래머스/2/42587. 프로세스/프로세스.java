import java.util.*;

class Solution {
    static class Process{
        int priority;
        int index;
        Process(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> queue = new ArrayDeque<>();

        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        while(!queue.isEmpty()){
            Process current = queue.poll();
            
            boolean isMax = true;
            for(Process p : queue){
                if(p.priority > current.priority) isMax = false;
            }
            if(!isMax){
                queue.offer(current);
            } else{
                if(current.index == location){
                    break;
                }
                answer++;
            }
        }
        return answer;
    }
}