import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> permuSet;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        permuSet = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        permu(0, 0, new int[M], new boolean[N]);

        for (int[] set : permuSet) {
            for (int i = 0; i < set.length; i++) {
                System.out.print(set[i] + " ");
            }
            System.out.println();
        }
    }

    static void permu(int index, int depth, int[] sel, boolean[] visited){
        if(depth==M){
            permuSet.add(Arrays.copyOf(sel, depth));
            return;
        }

        for (int i = index; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = arr[i];
                permu(i+1, depth+1, sel, visited);
                visited[i] = false;
            }
        }
    }
}
