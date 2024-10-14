import java.util.*;

class Solution {
    public int solution(String s) {
        String answerTemp = "";
        int answer = 0;
        String temp = "";
        Map<String, Integer> numList = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
        );
        for(char letter : s.toCharArray()){
            if(Character.isLetter(letter)){
                temp += letter;
                if(numList.get(temp)!=null){
                    answerTemp+=numList.get(temp);
                    temp = "";
                }
            }else if(Character.isDigit(letter)){
                answerTemp+=letter;
            }
        }
        answer = Integer.parseInt(answerTemp);
        return answer;
    }
}