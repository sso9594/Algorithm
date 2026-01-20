import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<i+s.length(); j++){
                sb.append(s.charAt(j % s.length()));
            }
            String str = sb.toString();
            
            Stack<Character> stack = new Stack<>();
            Stack<Character> temp = new Stack<>();
            
            String front = "({[";
            String back = "]})";
            
            boolean valid = true;
            
            if(front.contains(str.charAt(0)+"")){
                stack.push(str.charAt(0));
            } else {
                continue;
            }
            
            for(int j=1; j<str.length(); j++){
                char ch = str.charAt(j);
                if(front.contains(ch+"")){
                    stack.push(ch);
                } else if(back.contains(ch+"")){
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    char top = stack.pop();
                    if((top == '(' && ch == ')') || (top == '{' && ch == '}')
                       || (top == '[' && ch == ']')){
                        continue;
                    }
                    valid = false;
                    break;
                }
            }
            
            if(valid && stack.isEmpty()) answer++;
        }
        return answer;
    }
}