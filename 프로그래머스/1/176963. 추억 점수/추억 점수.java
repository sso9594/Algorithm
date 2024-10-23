import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int sum = 0;
        int count = 0;
        Map<String, Integer> hashmap = new HashMap<>();
        for(int i=0; i<name.length; i++){
            hashmap.put(name[i], yearning[i]);
        }
        for(String[] photoList : photo){
            for(String one : photoList){
                sum += hashmap.getOrDefault(one,0);
            }
            answer[count] = sum;
            sum = 0;
            count++;
        }
        
        return answer;
    }
}