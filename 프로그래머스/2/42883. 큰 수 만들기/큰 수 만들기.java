import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int idx = 0;
        stack.push(Integer.parseInt(number.charAt(0)+""));
        for(int i=1; i<number.length(); i++){
            int cur = Integer.parseInt(number.charAt(i)+"");
            if(stack.peek() > cur){
                stack.push(cur);
            } else{
                while(!stack.isEmpty() && stack.peek() < cur){
                    stack.pop();
                    count++;
                    if(count==k) break;
                }
                stack.push(cur);
                if(count==k) {
                    idx = i;
                    break;
                }
            }
        }
        for(int i=idx+1; i<number.length(); i++){
            int cur = Integer.parseInt(number.charAt(i)+"");
            stack.push(cur);
        }
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k -1;
        idx = 0;
        for(int num : stack){
            sb.append(Integer.toString(num));
            if(idx++ == len) break;
        }
        answer = sb.toString();
        return answer;
    }
}