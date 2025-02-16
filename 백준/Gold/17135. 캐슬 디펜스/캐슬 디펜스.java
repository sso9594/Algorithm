import java.io.*;
import java.util.*;

public class Main {

    static Set<int[]> permuSet;
    static int[] arrow;
    static int N;
    static int M;
    static int D;
    // 왼 위 오
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int max = 0;

        arrow = new int[M];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            map.add(temp);
        }

        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    // 모든 3명의 궁수 세트
                    arrow[i] = 1;
                    arrow[j] = 1;
                    arrow[k] = 1;
                    // 변수 선언
                    int killCnt = 0;
                    // 맵 복사
                    ArrayList<ArrayList<Integer>> cpy = new ArrayList<>();
                    for (int l = 0; l < map.size(); l++) {
                        cpy.add(new ArrayList<>(map.get(l)));
                    }
                    // 여기서 부터 시뮬레이션 로직
                    for (int round = 0; round < N; round++) {
                        killCnt += attack(cpy, arrow);
                        changeGrill(cpy);
                    }
                    max = Math.max(max, killCnt);
                    arrow[k] = 0;
                }
                arrow[j] = 0;
            }
            arrow[i] = 0;
        }

        System.out.println(max);
    }

    // 해당 회차 잡은 적의 수 반환
    static int attack(ArrayList<ArrayList<Integer>> map, int[] arrow){
        Set<ArrayList<Integer>> targets = new HashSet<>();
        // 궁수를 기준으로 계산
        for (int i = 0; i < M; i++) {
            if(arrow[i]==1){
                ArrayList<Integer> target = findTarget(map, i);
                if(target!=null){
                    targets.add(target);
                }
            }
        }

        for (ArrayList<Integer> target : targets) {
            map.get(target.get(0)).set(target.get(1), 0);
        }

        return targets.size();
    }

    // BFS로 가장 가까운 적 탐색
    static ArrayList<Integer> findTarget(ArrayList<ArrayList<Integer>> map, int arrowPos){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, arrowPos, 0});
        boolean[][] visited = new boolean[N][M];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int range = current[2];

            if (range > D) {
                break;
            }

            if(currentX<N && map.get(currentX).get(currentY)==1){
                return new ArrayList<>(Arrays.asList(currentX, currentY));
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M 
                && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, range+1});
                }
            }
        }

        return null;
    }

    static void changeGrill(ArrayList<ArrayList<Integer>> arr){
        arr.remove(N-1);
        arr.add(0,new ArrayList<>(Collections.nCopies(M, 0)));
    }
}