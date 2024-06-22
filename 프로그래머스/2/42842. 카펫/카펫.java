class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // yellow의 가로 = brown의 가로 - 2 => brown 가로 = yellow 가로 + 2
        // yellow의 세로 = brown의 세로 - 2 => brown 세로 = yellow 세로 + 2
        int col = 0;
        int row = 0;
        
        for(int i = 1; i<=yellow; i++){
            int current_w = 0;
            
            if((yellow%i == 0)){
                current_w = (int)(yellow/i)+2;
            }
            int current_h = i+2;
            
            if(((current_w * 2) + (current_h - 2) * 2) == brown){
                if(current_w >= current_h){
                    answer[0] = current_w;
                    answer[1] = current_h;
                }else{
                    answer[0] = current_h;
                    answer[1] = current_w;
                }
                break;
            } 
            
        }
        return answer;
    }
}