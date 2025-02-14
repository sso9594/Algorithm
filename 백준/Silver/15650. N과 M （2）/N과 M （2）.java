import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1,0);
    }
    public static void dfs(int a, int depth){
        if(depth == m){
            for(int val: arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i =a; i<=n; i++){
                arr[depth] = i;
                dfs(i+1, depth+1);
        }
    }
}