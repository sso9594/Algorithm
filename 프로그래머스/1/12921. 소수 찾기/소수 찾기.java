class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = true;
        }
        
        arr[0] = arr[1] = false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(arr[i]){
                for(int j=i*i; j<=n; j+=i){
                    arr[j] = false;
                }
            }
        }
        
        for(boolean target : arr){
            if(target) answer++;
        }
        return answer;
    }
}