import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] parents;
    static void make(){
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int find(int x){
        if(parents[x] == x){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y){
        int xRt = find(x);
        int yRt = find(y);

        if(xRt==yRt) return false;
        parents[xRt] = yRt;
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            make();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;

                union(a, b);
            }

            for (int i = 0; i < N; i++) {
                find(i);
            }

            boolean[] check = new boolean[N];
            for (int i = 0; i < N; i++) {
                check[parents[i]] = true;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if(check[i]) count++;
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
