class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        try{
            if(s.length()==4 || s.length()==6){
                Integer check = Integer.parseInt(s);
            }
            else
                answer = false;
        }catch(NumberFormatException e){
            answer = false;
        }
        return answer;
    }
}