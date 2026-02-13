import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String token = nary(n, k);
        String[] nums = token.split("0");
        System.out.println(Arrays.toString(nums));
        for(String num : nums){
            try{
                if(isPrime(Long.parseLong(num))) answer++;
            } catch(NumberFormatException e){
                continue;
            }
        }
        return answer;
    }
    
    boolean isPrime(long num){
        if(num<=1) return false;
        for(long i=2; i<=Math.sqrt(num); i++){
            if(num%i==0L) return false;
        }
        return true;
    }
    
    String nary(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n > 1){
            sb.append(n%k);
            n/=k;
        }
        if(n == 1) sb.append(n);
        
        return sb.reverse().toString();
    }
}