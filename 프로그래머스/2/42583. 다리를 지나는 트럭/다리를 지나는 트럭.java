import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int sum = 0;
        int index = 0;

        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        while (!queue.isEmpty()) {
            answer++;
            sum -= queue.poll();

            if (index < truck_weights.length) {
                if (sum + truck_weights[index] <= weight) {
                    queue.add(truck_weights[index]);
                    sum += truck_weights[index];
                    index++;
                } else {
                    queue.add(0);
                }
            }
        }

        return answer;
    }
}