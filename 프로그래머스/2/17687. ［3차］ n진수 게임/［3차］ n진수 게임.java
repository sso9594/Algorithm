class Solution {
    public String solution(int n, int t, int m, int p) {
        
        String answer = "";
        int len = m * t;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for(int i=1; i<=len; i++){
            sb.append(nary(i, n));
        }
        String str = sb.toString();
        sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(i % m == p-1){
                sb.append(str.charAt(i));
                count++;
            }
            if(count == t) break;
        }
        answer = sb.toString();
        return answer;
    }
    
    String nary(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int result = num%n;
            if(result >= 10){
                sb.append((char)('A'+ (result - 10)));
            } else {
                sb.append(result);
            }
            num/=n;
        }
        
        return sb.reverse().toString();
    }
}