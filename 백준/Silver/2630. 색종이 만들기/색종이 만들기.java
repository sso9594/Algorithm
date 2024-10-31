import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void check(int x, int y, int n){
        int count = 0;
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(paper[i][j]==1) count++;
            }
        }
        if(count==Math.pow(n,2)){
            blue++;
        } else if (count == 0){
            white++;
        } else{
            check(x, y, n/2);
            check(x+n/2, y, n/2);
            check(x, y+n/2, n/2);
            check(x+n/2, y+n/2, n/2);
        }
    }

}
