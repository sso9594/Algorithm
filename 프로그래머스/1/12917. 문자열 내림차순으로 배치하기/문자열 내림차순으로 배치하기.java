import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(Character.toString(s.charAt(i)));
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0;i<s.length();i++){
            answer += list.get(i);
        }
        return answer;
    }
}