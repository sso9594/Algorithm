import java.util.*;

class Solution {
    class Node {
        int num;
        int idx;
        
        Node (int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            int cur = numbers[i];
            if(stack.isEmpty()){
                stack.push(new Node(cur, i));
                continue;
            }
            while (!stack.isEmpty() && stack.peek().num < cur){
                Node popNode = stack.pop();
                answer[popNode.idx] = cur;
            }
            stack.push(new Node(cur, i));
        }
        
        for(Node node : stack){
            answer[node.idx] = -1;
        }
        
        return answer;
    }
}
/**
[9, 6, 2]
[-1, 5, 6, 6, -1, -1]
*/