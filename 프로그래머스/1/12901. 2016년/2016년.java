import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        ArrayList<Integer> plusOne = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> plusTwo = new ArrayList<>(Arrays.asList(4,6,9,11));
        ArrayList<Integer> plusThree = new ArrayList<>(Arrays.asList(1,3,5,7,8,10,12));
        for(int i=1; i<=a-1; i++){
            if(plusOne.contains(i)){
                b+=1;
            }else if(plusTwo.contains(i)){
                b+=2;
            }else if(plusThree.contains(i)){
                b+=3;
            }
        }
        int result = (b-1)%7;
        switch(result){
            case 0:
                answer += "FRI";
                break;
            case 1:
                answer += "SAT";
                break;
            case 2:
                answer += "SUN";
                break;
            case 3:
                answer += "MON";
                break;
            case 4:
                answer += "TUE";
                break;
            case 5:
                answer += "WED";
                break;
            case 6:
                answer += "THU";
                break;
            default:
                break;
        }
        return answer;
    }
}