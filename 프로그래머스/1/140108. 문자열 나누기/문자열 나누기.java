class Solution {
    public int solution(String s) {
        int answer = 0;
        int headEq = 0;
        int headDiff = 0;
        char head = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(head == '\0'){
                head = s.charAt(i);
            }
            if(head==s.charAt(i)){
                headEq++;
            } else{
                headDiff++;
            }
            
            if(headEq==headDiff){
                head = '\0';
                answer++;
            } else if(i==s.length()-1){
                answer++;
            }
            
        }
        return answer;
    }
}