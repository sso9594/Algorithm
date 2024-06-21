import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        /* 1번 수포자 규칙 : 1,2,3,4,5
           2번 수포자 규칙 : 2,1,2,3,2,4,2,5
           3번 수포자 규칙 : 3,3,1,1,2,2,4,4,5,5 */
        int[] answer_1 = {1,2,3,4,5};
        int[] answer_2 = {2,1,2,3,2,4,2,5};
        int[] answer_3 = {3,3,1,1,2,2,4,4,5,5};
        
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == answer_1[i%answer_1.length]) count_1++;
            if(answers[i] == answer_2[i%answer_2.length]) count_2++;
            if(answers[i] == answer_3[i%answer_3.length]) count_3++;
        }
        
        int max = Math.max(count_1, Math.max(count_2, count_3));
        
        List<Integer> list = new ArrayList<>();
        if (count_1 == max) list.add(1);
        if (count_2 == max) list.add(2);
        if (count_3 == max) list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}