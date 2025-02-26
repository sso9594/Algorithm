import java.util.Scanner;

public class Solution {
    static int N;
    static int B;
    static int[] arr;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            B = sc.nextInt();

            arr = new int[N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);

            System.out.println("#" + test_case + " " + (min - B));
        }
    }

    static void dfs(int index, int sum){
        if(sum >= B){
            min = Math.min(min, sum);
        }

        if(index == N) return;

        dfs(index+1, sum);
        dfs(index+1, sum+arr[index]);
    
    }
}
