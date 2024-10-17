class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
        while (n >= a) {
            int newCokes = (n / a) * b;
            int remainingCokes = n % a;
            count += newCokes;
            n = newCokes + remainingCokes;
        }
        
        return count;
    }
    
}