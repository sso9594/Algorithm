import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq, Comparator.reverseOrder());
        for(int i=0; i<freq.size(); i++){
            k-=freq.get(i);
            if(k<=0) {
                answer += i+1;
                break;
            }
        }
        
        return answer;
    }
}