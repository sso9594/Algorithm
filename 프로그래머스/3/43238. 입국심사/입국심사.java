class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long right = 1_000_000_000L * 1_000_000_000L;
        long left = 0;
        while(left <= right){
            long mid = (right + left) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid / time;
            }
            if(sum>=n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}