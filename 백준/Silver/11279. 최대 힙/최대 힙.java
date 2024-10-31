import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> heap = new PriorityQueue<>((p1, p2) -> {
            return Long.compare(p2, p1);
        }
        );
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            long x = Long.parseLong(br.readLine());
            if(x>0){
                heap.add(x);
            } else if(x==0){
                if(heap.size()==0){
                    System.out.println(0);
                } else{
                    System.out.println(heap.poll());
                }
            }
        }
    }
}
