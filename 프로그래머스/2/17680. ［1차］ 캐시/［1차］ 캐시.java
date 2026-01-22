import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        for(String city : cities){
            String str = city.toUpperCase();
            if(deque.contains(str)){
                answer++;
                deque.remove(str);
            } else{
                answer+=5;
            }
            deque.offer(str);
            if(deque.size() > cacheSize){
                deque.poll();
            }
        }
        return answer;
    }
}

/**

*/