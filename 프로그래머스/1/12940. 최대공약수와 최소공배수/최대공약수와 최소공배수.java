class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if (n<m){
            int temp = m;
            m = n;
            n = temp;
        }
        
        answer[0] = yaksu(n,m);
        answer[1] = besu(n,m,answer[0]);
        
        return answer;
    }
    
    static int yaksu(int num1, int num2){
        int result = num1 % num2;
        if(result!=0){
            result = yaksu(num2, result);
            return result;
        }
        return num2;
    }
    
    static int besu(int num1, int num2, int yaksuNum){
        return num1 * num2 / yaksuNum;
    }

}