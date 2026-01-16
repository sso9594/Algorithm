import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        ArrayList<int[]> fires = new ArrayList<>();
        int[] jihoon = new int[2];

        for (int i = 0; i < R; i++) {
            String token = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = token.charAt(j);
                if(map[i][j] == 'F'){
                    fires.add(new int[]{i, j});
                } else if(map[i][j] == 'J'){
                    jihoon[0] = i;
                    jihoon[1] = j;
                }
            }
        }

        Queue<int[]> fq = new ArrayDeque<>();
        boolean[][] vfq = new boolean[R][C];
        int[][] fireTimeMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTimeMap[i], -1);
        }

        for (int[] arr : fires){
            fq.add(new int[]{arr[0], arr[1], 0});
            vfq[arr[0]][arr[1]] = true;
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while (!fq.isEmpty()){
            int[] cur = fq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cT = cur[2];

            if(fireTimeMap[cx][cy] < cT) {
                fireTimeMap[cx][cy] = cT;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx<R && ny>=0 && ny<C && !vfq[nx][ny] && map[nx][ny] != '#'){
                    fq.offer(new int[]{nx, ny, cT+1});
                    vfq[nx][ny] = true;
                }
            }
        }

        Queue<int[]> jq = new ArrayDeque<>();
        boolean[][] vjq = new boolean[R][C];
        boolean valid = false;

        jq.offer(new int[]{jihoon[0], jihoon[1], 1});
        vjq[jihoon[0]][jihoon[1]] = true;

        while (!jq.isEmpty()){
            int[] cur = jq.poll();
            int cX = cur[0];
            int cY = cur[1];
            int cT = cur[2];

            if(cX == 0 || cY == 0 || cX == R-1 || cY == C-1){
                System.out.println(cT);
                valid = true;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX >= 0 && nX<R && nY>=0 && nY<C
                        && !vjq[nX][nY] && (fireTimeMap[nX][nY] == -1 || cT < fireTimeMap[nX][nY])
                && map[nX][nY] == '.'){
                    jq.offer(new int[]{nX, nY, cT+1});
                    vjq[nX][nY] = true;
                }
            }
        }

        if (!valid){
            System.out.println("IMPOSSIBLE");
        }

    }

}
