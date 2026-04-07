class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = 1_000_000_000L * 1_000_000_000L;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(int i=0; i<times.length; i++){
                count += mid / times[i];
            }
            
            if(count >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        return answer;
    }
}