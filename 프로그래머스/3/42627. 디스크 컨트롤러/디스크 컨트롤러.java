import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        int time = 0;
        int idx = 0;
        int count = jobs.length;
        
        while(idx < count || !queue.isEmpty()){
            // 현재 시간에 요청이 되어있는 작업을 대기 큐에 넣음
            while(idx < count && jobs[idx][0] <= time){
                queue.offer(jobs[idx++]);
            }
            
            // 작업이 있으면 하나만 처리
            if(!queue.isEmpty()){
                int[] task = queue.poll();
                time += task[1];
                answer += time - task[0];
            // 작업이 없으면 타임 점프
            } else{
                time = jobs[idx][0];
            }
        }
        
        return answer / count;
    }
}