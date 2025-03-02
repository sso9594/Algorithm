import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> permuSet;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
                bw.write(set[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    static void permu(int index, int depth, int[] sel, boolean[] visited){
        if(depth==M){
            permuSet.add(Arrays.copyOf(sel, depth));
            return;
        }
        
        if(index==N){
            return;
        }
        
        for (int i = 0; i < N; i++) {
            sel[depth] = arr[i];
            permu(index, depth+1, sel, visited);
        }
    }
}