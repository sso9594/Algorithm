import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=0; i<caseNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st1.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int j=0; j<n; j++){
                queue.offer(j);
            }

            int printCount = 0;

            while(!queue.isEmpty()){
                int current = queue.poll();
                boolean hasHigher = false;

                for(int k : queue){
                    if(arr[k] > arr[current]){
                        hasHigher = true;
                        break;
                    }
                }

                if(hasHigher){
                    queue.offer(current);
                }
                else{
                    printCount++;
                    if(current == m){
                        System.out.println(printCount);
                    }
                }
            }
            
        }
    }

}
