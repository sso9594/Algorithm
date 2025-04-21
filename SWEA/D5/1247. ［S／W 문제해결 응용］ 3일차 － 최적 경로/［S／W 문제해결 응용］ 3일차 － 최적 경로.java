import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] customers;
    static int[] company, home;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            customers = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            result = Integer.MAX_VALUE;
            permu(0, new int[N], new boolean[N]);

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void permu(int depth, int[] sel, boolean[] visited) {
        if (depth == N) {
            move(sel);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[depth] = i;
                permu(depth + 1, sel, visited);
                visited[i] = false;
            }
        }
    }

    static void move(int[] sel) {
        int dist = 0;

        dist += Math.abs(company[0] - customers[sel[0]][0]) + Math.abs(company[1] - customers[sel[0]][1]);

        for (int i = 0; i < N - 1; i++) {
            int[] cur = customers[sel[i]];
            int[] next = customers[sel[i + 1]];
            dist += Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]);
        }

        dist += Math.abs(customers[sel[N - 1]][0] - home[0]) + Math.abs(customers[sel[N - 1]][1] - home[1]);

        result = Math.min(result, dist);
    }

}