import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구이동 한 국가인지 아닌 국가인지를 체크하기 위한한
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        while (isOpenBorderline(visited)) {          
            count++;
            visited = new boolean[N][N];
        }
        
        System.out.println(count);
    }
    
    static boolean isOpenBorderline(boolean[][] visited){
        boolean isOpen = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean isValid = false;
                if(!visited[i][j]){
                    isValid = bfs(i, j, visited);
                }
                if(isValid) isOpen = true;
            }
        }

        return isOpen;
    }

    static boolean bfs(int x, int y, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> set = new HashSet<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        boolean doBfs = false;

        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            sum += map[currentX][currentY];
            set.add(new int[]{currentX, currentY});
            count++;
            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N && !visited[nextX][nextY] &&
                Math.abs(map[currentX][currentY] - map[nextX][nextY]) >= L &&
                Math.abs(map[currentX][currentY] - map[nextX][nextY]) <= R){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    doBfs = true;
                }
            }
        }

        if(doBfs){
            int divide = sum / count;

            for (int[] is : set) {
                map[is[0]][is[1]] = divide;
            }
            return true;
        } else{
            return false;
        }
        
    }
}