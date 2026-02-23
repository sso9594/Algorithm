import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        int count = 1;
        for(int i=0; i<26; i++){
            char ch = (char)('A' + i);
            map.put(String.valueOf(ch), count++);
        }
        
        int i = 0;
        List<Integer> arr = new ArrayList<>();
        
        while(i < msg.length()){
            int j = i + 1;
            while(j <= msg.length() && map.containsKey(msg.substring(i, j))){
                j++;
            }
            String str = msg.substring(i, j-1);
            arr.add(map.get(str));
            
            if(j <= msg.length()){
                map.put(msg.substring(i, j), count++);
            }
            
            i += j-i-1;
        }
        
        answer = new int[arr.size()];
        
        for(int k=0; k<answer.length; k++){
            answer[k] = arr.get(k);
        }
        
        return answer;
    }
}