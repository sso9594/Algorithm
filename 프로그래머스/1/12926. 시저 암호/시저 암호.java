class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] words = s.toCharArray();
        for(char word : words){
            if(word==' '){
                answer+=word;
                continue;
            }
            if(word>='a' && word<= 'z'){
                answer += ((char)((word - 'a' + n) % 26 + 'a'));
            }
            else if(word>='A' && word <= 'Z'){
                answer += ((char)((word - 'A' + n) % 26 + 'A'));
            }
        }
        return answer;
    }
}