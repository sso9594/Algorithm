import java.util.*;

class Solution {
    
    String[] answer;
    boolean valid;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        answer = new String[tickets.length + 1];
        valid = true;
        
        answer[0] = "ICN";
        
        dfs("ICN", 0, tickets, new String[tickets.length], new boolean[tickets.length]);
        
        return answer;
    }
    
    void dfs(String cur, int depth, String[][] tickets, String[] sel, boolean[] visited){
        if(!valid) return;
        if(depth == tickets.length){
            for(int i=1; i<answer.length; i++){
                answer[i] = sel[i-1];
            }
            valid = false;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                sel[depth] = tickets[i][1];
                visited[i] = true;
                dfs(tickets[i][1], depth+1, tickets, sel, visited);
                visited[i] = false;
            }
        }
    }
}