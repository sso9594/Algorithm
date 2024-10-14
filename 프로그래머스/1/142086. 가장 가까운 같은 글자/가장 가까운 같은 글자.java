import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int count = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char word : s.toCharArray()){
            if(hash.get(word)==null){
                answer[count] = -1;
                hash.put(word, count);
            }else{
                answer[count] = count - hash.get(word);
                hash.put(word, count);
            }
            count ++;
        }
        return answer;
    }
}