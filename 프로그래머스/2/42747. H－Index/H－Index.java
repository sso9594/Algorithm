import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // n번이상 인용된 논문이 n개이상이면 n은 H-Index 후보군
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int count = citations.length - i;
            if(citations[i] >= count){
                if(answer < count){
                    answer = count;
                }
            }
        }
        
        return answer;
    }
}