import java.util.*;

class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        permu(k, dungeons, dungeons.length, 0, new int[dungeons.length], new boolean[dungeons.length]);
        return answer;
    }
    
    void permu(int k, int[][] dungeons, int n, int depth, int[] sel, boolean[] visited){
        if(depth == n){
            calc(k, dungeons, sel);
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                sel[depth] = i;
                visited[i] = true;
                permu(k, dungeons, n, depth+1, sel, visited);
                visited[i] = false;
            }
        }
    }
    
    void calc(int k, int[][] dungeons, int[] sel){
        int count = 0;
        for(int i=0; i<sel.length; i++){
            int cur = sel[i];
            if(dungeons[cur][0] <= k){
                k -= dungeons[cur][1];
                count++;
            } else{
                break;
            }
        }
        answer = Math.max(answer, count);
    }
}