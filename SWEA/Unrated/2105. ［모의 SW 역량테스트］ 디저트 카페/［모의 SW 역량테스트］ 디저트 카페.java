import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int result;
    // 우하 좌하 좌상 우상
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,-1,1};
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = -1;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    countTea(i, j);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }


    private static void countTea(int x, int y) {
        Set<Integer> visited = new HashSet<>();
        visited.add(map[x][y]);
        dfs(x, y, x, y, visited, 0, 1, 1);
    }


    private static void dfs(int startX, int startY, int x, int y, Set<Integer> visited, int dir, int turn, int count) {
    for (int d = dir; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        // 범위 밖이면 skip
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

        // 시작점으로 돌아왔고, 4방향 다 돌았으면 완성
        if (nx == startX && ny == startY && turn >= 3) {
            result = Math.max(result, count);
            return;
        }

        int nextVal = map[nx][ny];
        if (!visited.contains(nextVal)) {
            visited.add(nextVal);
            dfs(startX, startY, nx, ny, visited, d, d == dir ? turn : turn + 1, count + 1);
            visited.remove(nextVal); // 백트래킹
        }
    }
}
    

    // private static int countTea(int[][] map, int x, int y) {
    //     int count = 0;

    //     // 우하
    //     for (int i = x+1, j = y+1; i < N && j < N; i++, j++) {
    //         // 좌하
    //         List<Integer> arr = new ArrayList<>(); 
    //         for (int p = x+1, q = y+1; p <= i && q<=j; p++, q++) {
    //             arr.add(map[p][q]);
    //         }
    //         arr.add(map[i][j]);
    //         for (int i1 = i+1, j1 = j-1; i1 < N && j1 >= 0; i1++, j1--) {
    //             // 좌상
    //             List<Integer> arr1 = new ArrayList<>();
    //             for (int p = i+1, q = j-1; p <= i1 && q >=j1; p++, q--) {
    //                 arr1.add(map[p][q]);
    //             }
    //             for (int i2 = i1-1, j2 = j1-1; i2 >= 0 && j2 >= 0; i2--, j2--) {
    //                 // 우상
    //                 arr.add(map[i2][j2]);
    //                 for (int i3 = i2-1, j3 = j2+1; i3 >= 0 && j3 < N; i3--, j3++) {
    //                     arr.add(map[i3][j3]);
    //                     if(x==i3 && y==j3) {
    //                         count++;
    //                     }
    //                 }
    //             }
    //             for (int k = 0; k < arr1.size(); k++) {
    //                 arr.remove(arr.size()-1);
    //             }
    //         }
    //     }

    //     return count;
    // }
}