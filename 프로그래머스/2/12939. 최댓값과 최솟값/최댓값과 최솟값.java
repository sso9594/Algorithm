import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<list.length; i++){
            arr.add(Integer.parseInt(list[i]));
        }
        
        Collections.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr.get(0));
        sb.append(" ");
        sb.append(arr.get(arr.size()-1));
        
        answer = sb.toString();
        return answer;
    }
}