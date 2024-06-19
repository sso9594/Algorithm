import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int j=0; j<completion.length; j++){
            hash.put(completion[j], hash.getOrDefault(completion[j], 0) - 1);
        }
        
        for(Map.Entry<String, Integer> entry : hash.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return answer;
    }
}