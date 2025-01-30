import java.util.Scanner;

public class Solution {

    static int R;
    static int C;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            R = sc.nextInt();
            C = sc.nextInt();

            map = new char[R][C];
            max = 1;

            for (int i = 0; i < R; i++) {
                String token = sc.next();
                for (int j = 0; j < C; j++) {
                    map[i][j] = token.charAt(j);
                }
            }

            dfs("", 0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(String token, int i, int j){
        if(token.contains(map[i][j]+"")){
            max = Math.max(max, token.length());
            return;
        }

        token += map[i][j];

        for (int k = 0; k < dx.length; k++) {
            if(i+dx[k]>=0 && j+dy[k]>=0 && i+dx[k]<R && j+dy[k]<C){
                dfs(token, i+dx[k], j+dy[k]);
            }
        }
    }
}
