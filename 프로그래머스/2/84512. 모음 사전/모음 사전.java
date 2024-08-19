class Solution {
    static int answer = 0;
    public int solution(String word) {
        
        dfs("", word);
        return answer;
    }
    
    static boolean dfs(String now, String word){
        if(now.equals(word))
            return true;
        if(now.length() == 5)
            return false;
        
        answer++;
        if(dfs(now+'A', word))
            return true;
        answer++;
        if(dfs(now+'E', word))
            return true;
        answer++;
        if(dfs(now+'I', word))
            return true;
        answer++;
        if(dfs(now+'O', word))
            return true;
        answer++;
        if(dfs(now+'U', word))
            return true;
        
        return false;
            
    }

}