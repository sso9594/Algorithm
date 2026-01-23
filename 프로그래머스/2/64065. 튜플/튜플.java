import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] words = s.split("},");
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        int idx = 0;
        for(String str : words){
            ArrayList<Integer> list = new ArrayList<>();
            String[] splits = words[idx++].split(",");
            for(String sp : splits){
                StringBuilder num = new StringBuilder();
                for(int i=0; i<sp.length(); i++){
                    if(Character.isDigit(sp.charAt(i))){
                        num.append(sp.charAt(i)+"");
                    }
                }
                if(!num.toString().equals("")){
                    list.add(Integer.parseInt(num.toString()));
                }
            }
            arr.add(list);
        }
        
        Collections.sort(arr, (a1, a2) -> Integer.compare(a1.size(), a2.size()));
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(arr.get(0).get(0));
        
        for(int i=1; i<arr.size(); i++){
            ArrayList<Integer> carr = new ArrayList<>(arr.get(i));
            carr.removeAll(arr.get(i-1));
            ans.add(carr.get(0));
        }
        
        answer = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}