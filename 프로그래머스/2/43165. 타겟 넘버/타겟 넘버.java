import java.util.*;

class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        
        bfs(numbers, target);
        
        return count;
    }
    
    static void bfs(int[] numbers, int target){
        Queue<int[]> queue = new LinkedList<>();
        // 시작, 합
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNum = current[0];
            int currentSum = current[1];
            if(currentNum == numbers.length){
                if(currentSum == target){
                    count++;
                }
                continue;
            }
            
            queue.offer(new int[] {currentNum + 1, currentSum + numbers[currentNum]});
            queue.offer(new int[] {currentNum + 1, currentSum - numbers[currentNum]});
        }
    }
}