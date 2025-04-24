import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        // yellow의 약수 구하기
        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow%i==0) list.add(i);
        }
        // 곱해서 yellow가 나오는 약수 묶음 구하기
        // 두 수 * 2 - 4 = brown이 나오는 값 구하기
        for(int i=0; i<list.size(); i++){
            int num1 = list.get(i);
            int num2 = yellow / num1;
            
            int cal = (num1 + num2+4) * 2 - 4;
            if(cal == brown){
                answer[0] = Math.max(num1+2, num2+2);
                answer[1] = Math.min(num1+2, num2+2);
            }
        }
        return answer;
    }
}
/*
1 2 3 4 6 8 12 24

3 26 => 29 * 2 - 4 = 54
4 14 => 18 * 2 - 4 = 32
5 10 => 15 * 2 - 4 = 26 
6 8 =>  14 * 2 - 4 = 24 => brown


*/