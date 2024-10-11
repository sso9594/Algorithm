class Solution {
    static int count=0;
    
    public int solution(int[] number) {
        int answer = 0;
        dfs(number,0,0,0);
        answer = count;
        return answer;
    }
    
    static void dfs(int[] number, int start, int selected, int sum){
        if(selected==3){
            if(sum==0)
                count++;
            return;
        }
        
        for(int i=start; i<number.length; i++){
            dfs(number, i+1, selected+1, sum+number[i]);
        }
    }
}