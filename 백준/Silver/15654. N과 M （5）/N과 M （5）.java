import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0, 0, new int[M], new boolean[N]);

        bw.flush();
    }

    static void comb(int index, int depth, int[] sel, boolean[] visited) throws IOException{
        if(depth == M){
            for (int i = 0; i < sel.length; i++) {
                bw.write(sel[i] + " ");
            }
            bw.write("\n");
            return;
        }

        if(index==N){
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = arr[i];
                comb(i, depth+1, sel, visited);
                visited[i] = false;
            }
        }
        
    }
}
