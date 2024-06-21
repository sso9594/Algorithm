import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> cArray = new ArrayList<>();
        // 숫자를 문자열로 변환
        for(int number : numbers){
            String num = Integer.toString(number);
            cArray.add(num);
        }
        //람다식을 이용해 두 원소를 문자열로 더한 후 정수로 크기 비교
        cArray.sort((o1, o2) -> {
            int num1 = Integer.parseInt(o1 + o2);
            int num2 = Integer.parseInt(o2 + o1);
            return Integer.compare(num2, num1);
        });
        StringBuilder sb = new StringBuilder();
        for(String ans : cArray){
            sb.append(ans);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }
}