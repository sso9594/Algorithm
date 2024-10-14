import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int[] list = new int[201];
        ArrayList<Integer> array = new ArrayList<>();
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                list[numbers[i]+numbers[j]] = 1;
            }
        }
        for(int i=0; i<list.length; i++){
            if(list[i]==1){
                array.add(i);
            }
        }
        answer = array.stream().mapToInt(i->i).toArray();
        return answer;
    }
}