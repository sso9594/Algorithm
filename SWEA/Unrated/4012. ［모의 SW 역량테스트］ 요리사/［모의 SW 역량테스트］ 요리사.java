import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] recipe;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            recipe = new int[N][N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    recipe[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0,0,new int[N/2], N/2);

            System.out.println("#" + test_case + " " + result);
        }
    }
    static void comb(int depth, int index, int[] sel, int pivot) {
        if(depth == pivot){
            calC(sel);
            return;
        }

        if(index >= N) return;

        sel[depth] = index;
        comb(depth+1, index+1, sel, pivot);
        comb(depth, index+1, sel, pivot);
    }

    static void calC(int[] sel) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
    
        for (int i = 0; i < N; i++) {
            if (contains(sel, i)) A.add(i);
            else B.add(i);
        }
    
        int resultA = synergySum(A);
        int resultB = synergySum(B);
    
        result = Math.min(result, Math.abs(resultA - resultB));
    }
    
    // 배열에 값이 있는지 체크
    static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) return true;
        }
        return false;
    }
    
    // 조합으로 시너지 계산
    static int synergySum(List<Integer> group) {
        int sum = 0;
        for (int i = 0; i < group.size(); i++) {
            for (int j = i + 1; j < group.size(); j++) {
                int a = group.get(i);
                int b = group.get(j);
                sum += recipe[a][b] + recipe[b][a];
            }
        }
        return sum;
    }

}