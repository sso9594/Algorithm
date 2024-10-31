import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(heap.size()>0){
                    System.out.println(heap.poll());
                } else{
                    System.out.println(0);
                }
            } else if (x>0){
                heap.add(x);
            }
        }

    }
}
