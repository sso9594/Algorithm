class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;
        
        for(int[] size : sizes){
            max = Math.max(Math.max(size[0],size[1]),max);
            min = Math.max(Math.min(size[0],size[1]),min);
        }
        
        answer = min * max;
        
        return answer;
    }
}