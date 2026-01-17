class Solution {
    public int solution(int[] arr) {
        int buf = arr[0];
        
        for(int num : arr){
            int g = gcd(buf, num);
            buf = lcm(buf, num, g);
        }

        return buf;
    }
    
    int lcm(int a, int b, int gcd){
        return (a * b) / gcd;
    }
    
    int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}