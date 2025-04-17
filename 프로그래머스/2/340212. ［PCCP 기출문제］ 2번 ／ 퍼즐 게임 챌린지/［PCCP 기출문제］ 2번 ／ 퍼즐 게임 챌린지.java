class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // 이분탐색
        int left = 1;
        int right = 100_000;
        while(left <= right){
            int mid = (left+right)/2;
            if(isPossible(mid, diffs, times, limit)){
                answer = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return answer;
    }
    public boolean isPossible(int level, int[] diffs, int[] times, long limit){
        long time = 0;
        for(int i=0; i<diffs.length; i++){
            int diff = diffs[i];
            int curTime = times[i];
            int prevTime = i==0 ? 0 : times[i-1];
            int mistake = diff - level;
            
            if(diff <= level){
                time+=curTime;
            } else{
                time += mistake * (curTime + prevTime) + curTime;
            }
        }
        if(time <= limit){
            return true;
        }
        return false;
    }
}
        
// for(int level=1; level<=100_000; level++){
//     long time = 0L;
//     for(int i=0; i<diffs.length; i++){
//         // diff vs level 비교
//         if(diffs[i] <= level){
//             time++;
//             continue;
//         } else{
//             // diff - level번 반복
//             long temp = 0L;
//             for(int j=0; j<diffs[i] - level; j++){
//                 temp = time + times[i];
//             }
//             temp += times[i];
//             time += temp;
//         }
//     }
//     if(time <= limit){
//         answer = level;
//         break;
//     }
// }