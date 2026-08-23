import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            int size = command[1]-command[0]+1;
            int[] newArr = new int[size];
            for (int i = command[0], j = 0; i <= command[1]; i++, j++) {
                newArr[j] = array[i - 1]; 
            }
            Arrays.sort(newArr);
            answer[idx++] = newArr[command[2]-1];
        }
        return answer;
    }
}