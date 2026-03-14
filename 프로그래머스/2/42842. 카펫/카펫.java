import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(sum); i++){
            if(sum % i == 0){
                list.add(i);
            }
        }
        
        for(int num1 : list){
            int num2 = sum / num1;
            if(num1-2 > 0 && num2-2 > 0){
                num1 -= 2;
                num2 -= 2;
                
                int mul = num1 * num2;
                if(yellow == mul){
                    answer[0] = Math.max(num1+2, num2+2);
                    answer[1] = Math.min(num1+2, num2+2);
                }
            }
        }
        return answer;
    }
}

/**
12의 약수
1, 2, 3, 4, 6, 12
(1, 12), (2, 6), (3, 4)

48의 약수
(1, 48), (2, 24), (3, 16), (4, 12), (6, 8)
1 14 / 2 10 / 4 6
14 20 24 == yellow
*/