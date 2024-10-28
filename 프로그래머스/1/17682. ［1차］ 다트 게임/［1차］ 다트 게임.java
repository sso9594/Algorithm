import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        /* 
        - 기회는 3번, 각 기회당 점수는 0~10
        - 점수다음 S,D,T 가 오는데 각 1제곱, 2제곱, 3제곱
        - 옵션이 있을 수 있는데, (*, #) 존재 *는 방금 얻은 점수와 바로 이전 점수 2배, #는 해당 점수 마이너스
        - *는 첫번째에도 나올 수 있는데 이 경우 그 점수만 2배
        - *는 중첩 될 수 있는데 이 경우 4배
        - *와 #도 중첩 가능, 이 경우 -2배
        - 옵션은 둘다 가질 수 없음
        */
        String number = "";
        int count = -1;
        ArrayList<Integer> pointIndex = new ArrayList<>();
        for(int i=0; i<dartResult.length(); i++){
            if(Character.isDigit(dartResult.charAt(i))){
                number += dartResult.charAt(i);
            } else if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D'
                      || dartResult.charAt(i) == 'T') {
                int point = Integer.parseInt(number);
                count++;
                String target = String.valueOf(dartResult.charAt(i));
                if(target.equals("S")){
                    pointIndex.add(point);
                } else if(target.equals("D")){
                    pointIndex.add((int)Math.pow(point,2));
                } else {
                    pointIndex.add((int)Math.pow(point,3));
                }
                number = "";
            } else {
                String option = String.valueOf(dartResult.charAt(i));
                if(option.equals("#")){
                    pointIndex.set(count, pointIndex.get(count) * -1);
                } else{
                    if(count < 1){
                        pointIndex.set(count, pointIndex.get(count) * 2);
                    } else{
                        pointIndex.set(count-1, pointIndex.get(count-1) * 2);
                        pointIndex.set(count, pointIndex.get(count) * 2);
                    }
                }
            }
        }
        for(int result : pointIndex){
            answer += result;
        }
        return answer;
    }
}