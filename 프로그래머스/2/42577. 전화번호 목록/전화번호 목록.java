import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(String target : phone_book){
            map.put(target, 1);
        }
        
        for(String target : phone_book){
            for(int i=1; i<target.length(); i++){
                if(map.containsKey(target.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
}