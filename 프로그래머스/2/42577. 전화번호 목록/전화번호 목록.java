import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], 1);
        }
        for(String token : phone_book){
            for(int i=0; i<token.length(); i++){
                if(map.containsKey(token.substring(0,i))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}