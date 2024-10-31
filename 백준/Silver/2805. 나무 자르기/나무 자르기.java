import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> trees = new ArrayList<>();
    static long N;
    static long M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long max = 0;
        

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            long temp = Integer.parseInt(st1.nextToken());
            if(temp > max) max = temp;
            trees.add(temp);
        }
        System.out.println(detect(0, max));
    }

    static long detect(long start, long end){
        long result = 0;
        while(start<=end){
            long flat = (start + end) / 2;
            long sum = 0;
            for(int i=0; i<N; i++){
                long temp = trees.get(i) - flat;
                if(temp > 0){
                    sum += temp;
                }
            }

            if(sum >= M){
                result = flat;
                start = flat + 1;
            } else{
                end = flat - 1;
            }

        }
        return result;
    }
}
