import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings, (o1, o2) ->{
            int cmp = o1.charAt(n) - o2.charAt(n);
            if(cmp == 0){
                return o1.compareTo(o2);
            }
            return cmp;
        });
        answer = strings;
        return answer;
    }
}