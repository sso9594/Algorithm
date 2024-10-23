import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        List<Integer> c1List = new ArrayList<>();
        List<Integer> c2List = new ArrayList<>();
        for(int i=0; i<goal.length; i++){
            map.put(goal[i], i);
        }
        for(int i=0; i<cards1.length; i++){
            c1List.add(map.getOrDefault(cards1[i], Integer.MAX_VALUE));
        }
        for(int i=0; i<cards2.length; i++){
            c2List.add(map.getOrDefault(cards2[i], Integer.MAX_VALUE));
        }
        int prefix = 0;
        for(int num : c1List){
            if(prefix > num){
                answer += "No";
                return answer;
            }
            prefix = num;
        }
        prefix = 0;
        for(int num : c2List){
            if(prefix > num){
                answer += "No";
                return answer;
            }
            prefix = num;
        }
        answer += "Yes";
        return answer;
    }
}