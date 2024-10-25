import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int user = stages.length;
        double[] rates = new double[N];
        for(int i=0 ;i<N; i++){
            int count = 0;
            for(int j=0; j<stages.length; j++){
                if((i+1)==stages[j]){
                    count++;
                }
            }
            if(user==0) user++;
            rates[i] = (double)count / (double)user;
            user -= count;
        }
        for(int i=0; i<rates.length; i++){
            int big = 0;
            for(int j=0; j<rates.length; j++){
                if(rates[big] < rates[j]){
                    big = j;
                }
            }
            answer[i] = big + 1;
            rates[big] = -1;
        }
        
        return answer;
    }
}