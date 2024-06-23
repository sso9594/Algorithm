class Solution {
    
    static boolean[] visited;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }
    private void dfs(int[][] dungeons, int k, int count){
        answer = Math.max(answer, count);
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] == false && dungeons[i][0] <= k){
                visited[i] = true;
                k -= dungeons[i][1];
                
                dfs(dungeons, k, count + 1);
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}