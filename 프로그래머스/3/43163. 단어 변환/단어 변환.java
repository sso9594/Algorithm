/**
1. 하나의 알파벳만 바꿀 수 있음
2. words 목록에 있는 단어만 바꿀 수 있음

begin -> target까지의 거리를 구하시오 (불가능 시 0 출력)
*/
import java.util.*;

class Solution {
    class Node {
        String str;
        int count;
        
        Node(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            String curStr = cur.str;
            int count = cur.count;
                        
            if(curStr.equals(target)){
                answer = count;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                int nxtCnt = count + 1;
                if(!visited[i] && canConvert(curStr, words[i])){
                    queue.offer(new Node(words[i], nxtCnt));
                    visited[i] = true;
                }
            }
        }
                                
        return answer;
    }
    
    public boolean canConvert(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        
        return count==1;
    }
}