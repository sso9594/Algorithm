import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int num : citations){
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i<list.size(); i++){
            if(list.get(i) >= i+1){
                answer = i+1;
            }
        }
        return answer;
    }
}