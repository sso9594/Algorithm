class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum=0;
        for(long i=1; i<=count; i++){
            sum += (long)price * (long)i;
        }
        if(sum > money)
            answer = sum - (long)money;
        return answer;
    }
}