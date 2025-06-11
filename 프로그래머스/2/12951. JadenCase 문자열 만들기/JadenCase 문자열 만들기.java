import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean nextUpper = true;
        for(int i=0; i<s.length(); i++){
            char token = s.charAt(i);
            if(nextUpper){
                answer.append(Character.toUpperCase(token));
            } else{
                answer.append(Character.toLowerCase(token));
            }
            if(token==' '){
                nextUpper = true;
            } else{
                nextUpper = false;
            }
        }
        return answer.toString();
    }
}