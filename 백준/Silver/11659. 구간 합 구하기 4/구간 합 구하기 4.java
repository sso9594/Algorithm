import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int sum = 0;
        arr.add(0);

        for(int i=0; i<N; i++){
            sum += Integer.parseInt(st1.nextToken());
            arr.add(sum);
        }
        
        int scope = 0;
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st2.nextToken());
            int J = Integer.parseInt(st2.nextToken());
            
            scope = arr.get(J) - arr.get(I-1);

            System.out.println(scope);
        }
    }
}
