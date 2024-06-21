class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int[] size : sizes){
            if(size[0] < size[1]){
                int temp = 0;
                temp = size[1];
                size[1] = size[0];
                size[0] = temp;
            }
        }
        int max_w = 0;
        int max_h = 0;
        for(int[] size : sizes){
            if(size[0] > max_w){
                max_w = size[0];
            }
            if(size[1] > max_h){
                max_h = size[1];
            }
        }
        answer = max_w * max_h;
        return answer;
    }
}