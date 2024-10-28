class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<skip.length(); i++){
            alphabet = alphabet.replaceAll(String.valueOf(skip.charAt(i)), "");
        }

        for(int i=0; i<s.length(); i++){
            int ch = alphabet.indexOf(s.charAt(i));
            int after = ch + index;
            if(after >= alphabet.length()){
                after %= alphabet.length();
            }
            answer += alphabet.charAt(after);
        }
        return answer;
    }
}