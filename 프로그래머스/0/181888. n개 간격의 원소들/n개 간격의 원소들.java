import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(int i=0; i<num_list.length; i+=n){
            answerList.add(num_list[i]);
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}