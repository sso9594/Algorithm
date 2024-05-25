import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<n+1; i++){
            queue.add(i);
        }

        while(queue.size()>1){
            queue.remove();
            int back = queue.poll();
            queue.add(back);
        }

        System.out.println(queue.poll());
    }
}
