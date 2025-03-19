import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();
        // 들어온 수가 크면 스택에 넣고 작으면 클 때까지 전부 pop
        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - index- 1;
        }
        
        return answer;
    }
}