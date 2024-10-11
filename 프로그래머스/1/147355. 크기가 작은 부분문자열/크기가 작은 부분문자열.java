import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        ArrayList<Long> arr = new ArrayList<>();
        for(int i=p.length(); i<=t.length(); i++){
            arr.add(Long.parseLong(t.substring(i-p.length(),i)));
        }
        for(long num : arr){
            if(num<=Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}