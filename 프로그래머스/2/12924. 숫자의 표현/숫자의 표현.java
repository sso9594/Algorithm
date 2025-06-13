class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int index = 1; index <= n; index++){
            int sum = 0;
            for(int i=index; i<=n; i++){
                sum += i;
                if(sum==n) {
                    answer++;
                    break;
                }
                if(sum>n){
                    break;
                }        
            }
        }
        return answer;
    }
}