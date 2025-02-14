import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int start,int depth){
        if(depth == m){
            for(int i =0; i<m; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = start; i<=n; i++){
            arr[depth] =i;
            dfs(start, depth+1);
            start+=1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[m];

        dfs(1,0);
        System.out.println(sb);
    }
}