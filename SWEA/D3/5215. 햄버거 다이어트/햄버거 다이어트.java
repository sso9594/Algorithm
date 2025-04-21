import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int L;
    static int result;
    static int[][] material;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            material = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                material[i][1] = Integer.parseInt(st.nextToken());
                material[i][0] = Integer.parseInt(st.nextToken());
            }

            result = 0;

            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void dfs(int cal, int index, int score){
        if(cal>L) return;
        if(index == N){
            result = Math.max(result, score);
            return;
        }

        dfs(cal+material[index][0], index+1, score + material[index][1]);
        dfs(cal, index+1, score);
    }

}