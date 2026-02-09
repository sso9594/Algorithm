import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            if(str1.charAt(i) < 'A' || str1.charAt(i) > 'Z' || 
              str1.charAt(i+1) < 'A' || str1.charAt(i+1) > 'Z' ||
              str1.charAt(i) == ' ' || str1.charAt(i+1) == ' '){
                continue;
            }
            
            arr1.add(str1.charAt(i) + "" + str1.charAt(i+1));
        }
        
        for(int i=0; i<str2.length()-1; i++){
            if(str2.charAt(i) < 'A' || str2.charAt(i) > 'Z' || 
              str2.charAt(i+1) < 'A' || str2.charAt(i+1) > 'Z' ||
              str2.charAt(i) == ' ' || str2.charAt(i+1) == ' '){
                continue;
            }
            arr2.add(str2.charAt(i) + "" + str2.charAt(i+1));
        }
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(String str : arr1){
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for(String str : arr2){
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        
        int inter =0;
        int union = 0;
        
        Set<String> keySets = new HashSet<>();
        
        keySets.addAll(map1.keySet());
        keySets.addAll(map2.keySet());
        
        for(String key : keySets){
            int val1 = map1.getOrDefault(key, 0);
            int val2 = map2.getOrDefault(key, 0);
            
            inter += Math.min(val1, val2);
            union += Math.max(val1, val2);
        }
        
        if(union == 0) return 65536;
        
        answer = (int) Math.floor((double) inter / union * 65536);
        
        return answer;
    }
}