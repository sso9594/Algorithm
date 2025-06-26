import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        
        Character prefix = words[0].charAt(words[0].length()-1);
        map.put(words[0], 1);
        
        /**
            (i%3)+1 => 몇번 째 사람인지
            i/3 => 몇번째 턴인지
        */
        for(int i=1; i<words.length; i++){
            String word = words[i];
            if(map.getOrDefault(word, -1) != -1){
                answer[0] = (i%n)+1;
                answer[1] = i/n+1;
                break;
            }
            if(word.charAt(0) != prefix){
                answer[0] = (i%n)+1;
                answer[1] = i/n+1;
                break;
            }
            prefix = word.charAt(word.length()-1);
            map.put(word, 1);
        }

        return answer;
    }
}