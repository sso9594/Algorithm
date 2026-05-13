/**
한번에 하나의 작업만 수행 가능
[작업번호, 요청시각, 소요시간]
우선순위: 소요시간 > 요청시각 > 번호
비선점
*/
import java.util.*;

class Solution {
    class Task {
        int id, start, time;
        Task (int id, int start, int time){
            this.id = id;
            this.start = start;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return id + " " + start + " " + time;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Task> startPQ = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.start, b.start)
        );
        PriorityQueue<Task> timePQ = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                if(t1.time != t2.time){
                    return Integer.compare(t1.time, t2.time);
                } else {
                    return Integer.compare(t1.id, t2.id);
                }
            }
        });
        for(int i=0; i<jobs.length; i++){
            startPQ.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        
        while(!startPQ.isEmpty() || !timePQ.isEmpty()){
            while(!startPQ.isEmpty() && startPQ.peek().start <= time){
                timePQ.add(startPQ.poll());
            }
            if(!timePQ.isEmpty()){
                Task task  = timePQ.poll();
                time += task.time;
                answer += time - task.start;
            } else {
                time++;
            }
        }
        
        return answer / jobs.length;
    }
}
