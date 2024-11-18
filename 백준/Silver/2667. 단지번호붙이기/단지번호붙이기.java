import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<N; i++){
            String token = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(token.charAt(j)+"");
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]==1){
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int num : result){
            System.out.println(num);
        }

    }
    // bfs를 통해 아파트 단지의 크기를 탐색하고, visited 배열을 통해 중복 연산 방지
    static int bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 1});
        visited[i][j] = true;

        int count = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentCnt = current[2];

            for(int x=0; x<4; x++){
                int nextX = currentX + dx[x];
                int nextY = currentY + dy[x];
                int nextCnt = currentCnt + 1;
                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N
                && !visited[nextX][nextY] && map[nextX][nextY]==1){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, nextCnt});
                    count++;
                }
            }

        }

        return count;

    }

}
