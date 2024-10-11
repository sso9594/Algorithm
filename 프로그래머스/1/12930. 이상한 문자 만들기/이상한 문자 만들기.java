import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        String[] token = s.split("");
        for(String word : token){
            if(word.equals(" ")){
                index = 0;
                answer += word;
            }else if(index%2==0){
                answer += word.toUpperCase();
                index++;
            }else{
                answer += word.toLowerCase();
                index++;
            }
        }
        return answer;
    }
}