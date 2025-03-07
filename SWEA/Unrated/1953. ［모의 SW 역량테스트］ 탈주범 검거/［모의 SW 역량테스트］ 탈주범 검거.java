import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,R,C,L;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 시작 위치 (R,C)
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            // 시간
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + test_case + " " + bfs(R, C));
        }
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 1});
        boolean[][] visited = new boolean[N][M];
        Set<List<Integer>> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int count = current[2];
            set.add(Arrays.asList(currentX, currentY));
            if(count>=L){    
                continue;
            }
            int[][] direction = findDirection(map[currentX][currentY]);
            for (int i = 0; i < direction.length; i++) {
                int nextX = currentX + direction[i][0];
                int nextY = currentY + direction[i][1];
                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M &&
                !visited[nextX][nextY] && map[nextX][nextY]!=0
                && isConnectNext(currentX, currentY, nextX, nextY)){
                    queue.offer(new int[]{nextX, nextY, count+1});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return set.size();
    }

    static boolean isConnectNext(int currentX, int currentY, int nextX, int nextY){
        // cur - next 해서 그게 next에 있는지 확인하고
        // next - cur 해서 그게 cur에 있는지 확인
        int[][] curDir = findDirection(map[currentX][currentY]);
        int[][] nextDir = findDirection(map[nextX][nextY]);

        boolean valid1 = false;
        boolean valid2 = false;

        for (int i = 0; i < nextDir.length; i++) {
            if(nextDir[i][0]==currentX-nextX && nextDir[i][1]==currentY-nextY){
                valid1 = true;
            }

            if(curDir[i][0]==nextX-currentX && curDir[i][1]==nextY-currentY){
                valid2 = true;
            }
        }

        return valid1 && valid2;
    }

    static int[][] findDirection(int type){
        // 상 하 좌 우
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int[][] direction;
        int index = 0;

        switch (type) {
            case 1:
                direction = new int[4][2];
                for (int i = 0; i < 4; i++) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 2:
                direction = new int[4][2];
                for (int i = 0; i < 2; i++) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 3:
                direction = new int[4][2];
                for (int i = 2; i < 4; i++) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 4:
                direction = new int[4][2];
                for (int i = 0; i < 4; i+=3) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 5:
                direction = new int[4][2];
                for (int i = 1; i < 4; i+=2) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 6:
                direction = new int[4][2];
                for (int i = 1; i < 3; i++) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            case 7:
                direction = new int[4][2];
                for (int i = 0; i < 4; i+=2) {
                    direction[index][0] = dx[i];
                    direction[index][1] = dy[i];
                    index++;
                }
                return direction;
            default:
                break;
        }

        return null;
    }
}