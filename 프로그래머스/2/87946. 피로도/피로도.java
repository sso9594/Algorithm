class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        int startIdx = 0;
        for(int i=1; i<dungeons.length; i++){
            if(dungeons[i][0] > dungeons[startIdx][0]){
                startIdx = i;
            }
        }
        
        dfs(0, startIdx, k, 0, dungeons, new boolean[dungeons.length]);
        
        return answer;
    }
    
    void dfs(int depth, int index, int stami, int count, int[][] dungeons, boolean[] visited){
        answer = Math.max(answer, count);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && stami >= dungeons[i][0]){
                visited[i] = true;
                dfs(depth+1, i, stami-dungeons[i][1], count+1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}