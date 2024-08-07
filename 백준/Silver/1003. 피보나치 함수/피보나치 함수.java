import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            fibonacci(Integer.parseInt(br.readLine()));
        }
        

    }

    private static void fibonacci(int n){
        int[][] fibArr = new int[41][2];

        fibArr[0][0] = 1;
        fibArr[0][1] = 0;
        fibArr[1][0] = 0;
        fibArr[1][1] = 1;

        for(int i=2; i<=n; i++){
            fibArr[i][0] = fibArr[i-1][0] + fibArr[i-2][0];
            fibArr[i][1] = fibArr[i-1][1] + fibArr[i-2][1];
        }

        System.out.print(fibArr[n][0] + " ");
        System.out.print(fibArr[n][1] + "\n");
    }
}