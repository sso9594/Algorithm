import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] parents;

    static void make(){
        parents = new int[N];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    static int find(int x){ // 대표값 반환
        if(parents[x] == x){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y){
        int xRt = find(x);
        int yRt = find(y);

        if(xRt == yRt) return false;
        parents[yRt] = xRt;
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            make();
            sb.append(("#" + test_case + " "));
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                switch (command) {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        int resultA = find(a);
                        int resultB = find(b);
                        sb.append((resultA == resultB ? 1:0));
                    default:
                        break;
                }
            }

            System.out.println(sb);
        }
    }
}
