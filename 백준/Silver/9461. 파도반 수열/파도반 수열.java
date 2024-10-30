import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] answers = new long[T];
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            long[] tri = new long[N+4];

            tri[0] = 0;
            tri[1] = 1;
            tri[2] = 1;
            tri[3] = 1;

            for(int j=4; j<=N; j++){
                tri[j] = tri[j-2] + tri[j-3];
            }

            answers[i] = tri[N];
        }

        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
