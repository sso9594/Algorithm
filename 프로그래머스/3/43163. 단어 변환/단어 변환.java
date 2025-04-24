import java.util.*;

class Solution {
    class Node{
        String token;
        int count;
        Node(String token, int count){
            this.token = token;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            String curStr = cur.token;
            int cCnt = cur.count;
            if(curStr.equals(target)){
                return cCnt;
            }
            for(int i=0; i<words.length; i++){
                if(!visited[i] && canConvert(words[i], curStr)){
                    queue.offer(new Node(words[i], cCnt+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    boolean canConvert(String token1, String token2){
        int count = 0;
        for(int i=0; i<token1.length(); i++){
            if(token1.charAt(i) != token2.charAt(i)){
                count++;
            }
        }
        
        return count==1;
    }
}