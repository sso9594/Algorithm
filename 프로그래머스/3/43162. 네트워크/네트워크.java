import java.util.*;

class Solution {
    int[] parents;
    int[] rank;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parents = new int[computers.length];
        rank = new int[computers.length];
        for(int i=0; i<computers.length; i++){
            parents[i] = i;
        }
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(i!=j && computers[i][j]==1){
                    unionSet(i,j);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<parents.length; i++){
            findSet(i);
            map.put(parents[i], map.getOrDefault(parents[i],0)+1);
        }
        answer = map.size();
        return answer;
    }
    
    void unionSet(int i, int j){
        int pi = findSet(i);
        int pj = findSet(j);
        
        if(rank[pi] > rank[pj]){
            parents[pj] = pi;
        } else{
            parents[pi] = pj;
            if(rank[pi] == rank[pj]){
                rank[pj]++;
            }
        }
    }
    
    int findSet(int x){
        if(parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }
}