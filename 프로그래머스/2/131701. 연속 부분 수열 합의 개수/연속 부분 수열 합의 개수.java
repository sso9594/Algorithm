import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=1; i<=elements.length; i++){
            int window = 0;
            for(int j=0; j<i; j++){
                window += elements[j];
            }
            map.put(window, 1);
            for(int j=1; j<elements.length; j++){
                window += elements[(i+j-1)%elements.length]- elements[j-1];
                map.put(window, 1);
            }
        }
        answer = map.size();
        return answer;
    }
}