import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<wires.length; i++){
            list.add(wires[i]);
        }
        for(int t=0; t<wires.length; t++){
            int[] cur = list.get(t);
            list.remove(t);
            
            int[][] adjMat = new int[n+1][n+1];
            for(int[] arr : list){
                adjMat[arr[0]][arr[1]] = 1;
                adjMat[arr[1]][arr[0]] = 1;
            }
            
            boolean[] visited = new boolean[n+1];
            int count = bfs(adjMat, visited, 1);
            int A = n - count;
            int B = count;
            
            answer = Math.min(Math.abs(A-B), answer);
            
            list.add(t, cur);
        }
        return answer;
    }
    
    int bfs(int[][] adjMat, boolean[] visited, int x){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()){
            int cNode = queue.poll();
            visited[cNode] = true;
            for(int i=0; i<adjMat[cNode].length; i++){
                if(!visited[i] &&adjMat[cNode][i] == 1){
                    queue.offer(i);
                }
            }
        }
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]) count++;
        }
        return count;
    }
}