import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> front = new HashMap<>();
        Map<Integer, Integer> back = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            back.put(topping[i], back.getOrDefault(topping[i], 0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            int num = topping[i];
            front.put(num, front.getOrDefault(num, 0)+1);
            if(back.containsKey(num)){
                if(back.get(num) == 1){
                    back.remove(num);
                } else{
                    back.put(num, back.get(num)-1);
                }
            }
            if(front.size() == back.size()) answer++;
        }
        return answer;
    }
}