class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int change = 0;
        int index = 0;
        while(s.length()>1){
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0'){
                    count++;
                }
            }
            s = Integer.toBinaryString(s.length()-count);
            change += count;
            index++;
        }
        answer[0] = index;
        answer[1] = change;
        return answer;
    }
}