import java.util.*;

class Solution {
    class Task {
        int s, l;
        Task(int s, int l){
            this.s = s;
            this.l = l;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Task> sq = new PriorityQueue<>((a, b) -> Integer.compare(a.s, b.s));
        PriorityQueue<Task> lq = new PriorityQueue<>((a, b) -> Integer.compare(a.l, b.l));
        
        for(int[] job : jobs){
            Task t = new Task(job[0], job[1]);
            sq.offer(t);
        }
        
        int t = sq.peek().s;
        
        while(!sq.isEmpty() || !lq.isEmpty()){
            while(!sq.isEmpty() && sq.peek().s <= t){
                lq.offer(sq.poll());
            }
            if(lq.isEmpty()){
                t = sq.peek().s;
                continue;
            }
            Task task = lq.poll();
            t += task.l;
            answer += t - task.s;
        }

        return answer / jobs.length;
    }
}

/**
소요시간 > 요청시각 > 작업 번호
*/