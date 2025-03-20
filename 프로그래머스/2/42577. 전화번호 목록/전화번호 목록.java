import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(String token : phone_book){
            map.put(token, 1);
        }
        for(String token : phone_book){
            for(int i=1; i<token.length(); i++){
                if(map.containsKey(token.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
}