import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        int sum = 0;
        
        for(int num : number){
            sum += num;
        }
        
        for(int i=0; i<discount.length; i++){
            String now = discount[i];
            
            if(map.containsKey(now) && i <= discount.length - sum){
                Map<String, Integer> collect = new HashMap<>();
                
                for(int j=i; j<i+sum; j++){
                    collect.put(discount[j], collect.getOrDefault(discount[j], 0)+1);
                }
                
                boolean valid = true;
                
                for(String str : want){
                    if(map.get(str) != collect.get(str)){
                        valid = false;
                        break;
                    }
                }
                
                if(valid) answer++;
            }
        }
        
        return answer;
    }
}