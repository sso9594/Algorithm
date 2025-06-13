class Solution {
    public int solution(int n) {
        int answer = 0;
        int one = 0;
        String bin = Integer.toBinaryString(n);
        for(int i=0; i<bin.length(); i++){
            if(bin.charAt(i) == '1'){
                one++;
            }
        }
        for(int i=n+1; i<=Integer.MAX_VALUE; i++){
            int count = 0; // 1의 갯수
            String bin2 = Integer.toBinaryString(i);
            for(int j=0; j<bin2.length(); j++){
                if(bin2.charAt(j) == '1'){
                    count++;
                }
            }
            if(one==count){
                answer = i;
                break;  
            } 
        }
            
        return answer;
    }
}