import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] warm;
    static long result;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            warm = new int[N][2];
            result = Long.MAX_VALUE;
            count = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                warm[i][0] = Integer.parseInt(st.nextToken());
                warm[i][1] = Integer.parseInt(st.nextToken());
            }

            // N의 수를 NC2씩 모두 짝지어야함
            comb(new int[N/2], 0, 0);

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void comb(int[] sel, int idx, int depth) {
        if (depth == N / 2) {
            calc(sel);
            count++;
            return;
        }

        if(idx >= N) return;
        
        sel[depth] = idx;
        comb(sel, idx+1, depth+1);
        comb(sel, idx+1, depth);
    }

    static void calc(int[] sel) {
        long aX = 0;
        long aY = 0;
        long bX = 0;
        long bY = 0;

        boolean[] visited = new boolean[N];

        for (int i=0; i<N/2; i++) {
            aX += warm[sel[i]][0];
            aY += warm[sel[i]][1];
            visited[sel[i]] = true;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                bX += warm[i][0];
                bY += warm[i][1];
            }
        }

        long sum = (aX - bX) * (aX - bX) + (aY - bY) * (aY - bY);
        result = Math.min(sum, result);
    }
}