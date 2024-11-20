import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if(absA == absB){
                return Integer.compare(a,b);
            }

            return Integer.compare(absA, absB);
        });
        
        for(int i=0; i<N; i++){
            int command = sc.nextInt();
            if(command!=0){
                queue.add(command);
            } else{
                int num = 0;
                if(queue.size()>0){
                    num = queue.poll();
                }
                System.out.println(num);
            }
        }
    }
}
