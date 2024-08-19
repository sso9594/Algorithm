class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        double mean = (double) sum / (double) arr.length;
        answer = mean;
        return answer;
    }
}