import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char cur = s.charAt(i);
            if(!stack.isEmpty() && cur == stack.peek()){
                stack.pop();
            } else{
                stack.push(cur);
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        } else{
            answer = 0;
        }

        return answer;
    }
}