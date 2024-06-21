import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;
        //commands의 갯수 만큼 반복하는 반복문
        for(int[] command : commands){
            // 자른 array를 담을 배열 초기화
            List<Integer> cutArray = new ArrayList<>();
            //array를 자르는 알고리즘
            for(int i=command[0]-1; i<=command[1]-1; i++){
                cutArray.add(array[i]);
            }
            Collections.sort(cutArray);
            answer[n] = cutArray.get(command[2]-1);
            n++;
        }
        return answer;
    }
}