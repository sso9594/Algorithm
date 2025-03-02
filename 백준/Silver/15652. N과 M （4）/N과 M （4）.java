import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static ArrayList<int[]> combSet;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        combSet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        comb(0, 0, new int[M]);

        for (int[] set : combSet) {
            for (int i = 0; i < set.length; i++) {
                bw.write(set[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    static void comb(int index, int depth, int[] sel){
        if(depth == M){
            combSet.add(Arrays.copyOf(sel, depth));
            return;
        }

        if(index==N){
            return;
        }

        for (int i = index; i < N; i++) {
            sel[depth] = arr[i];
            comb(i, depth+1, sel);
        }
    }
}
