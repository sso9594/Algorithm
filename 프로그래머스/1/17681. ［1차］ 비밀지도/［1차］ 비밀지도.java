class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int map = arr1[i] | arr2[i];
            
            StringBuilder sb = new StringBuilder();
            for(int j=n-1; j>=0; j--){
                if((map & (1<<j)) != 0){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}