import java.util.Scanner;

public class Solution {
    static int N;
    static int[][] cheese;
    static boolean[][] ate;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            cheese = new int[N][N];
            ate = new boolean[N][N];
            int num_max = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                    num_max = Math.max(num_max, cheese[i][j]);
                }
            }
            
            for (int i = 0; i <= num_max; i++) {
                // 해당 일 먹은 치즈 체크
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(cheese[j][k] == i){
                            ate[j][k] = true;
                        }
                    }
                }

                boolean[][] visited = new boolean[N][N];
                int count = 0;
                // 먹은 치즈 dfs로 덩이 수 체크
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(!ate[j][k] && !visited[j][k]){
                            dfs(j, k, visited);
                            count++;
                        }
                    }
                }

                max = Math.max(max, count);
            }

            System.out.println("#" + test_case + " " + max);
		}

	}

    static void dfs(int j, int k, boolean[][] visited){
        if(visited[j][k] || ate[j][k]){
            return;
        }

        visited[j][k] = true;

        for (int i = 0; i < dx.length; i++) {
            if (j+dx[i]<N && k+dy[i]<N && j+dx[i]>=0 && k+dy[i]>=0) {
                dfs(j+dx[i], k+dy[i], visited);
            }
        }
    }
}
