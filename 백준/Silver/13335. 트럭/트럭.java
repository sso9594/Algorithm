import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭의 갯수
        int w = sc.nextInt(); // 다리의 길이(다리 위 가능한 트럭의 갯수)
        int L = sc.nextInt(); // 다리 최대하중

        int[] arr = new int[n+1];
        // 큐 안에 트럭을 보관하고 큐 안의 값이 L, 큐의 사이즈가 w를 넘지 않도록 조절
        // 다리 역할
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<w; i++){
            queue.add(0);
        }
        int sum = 0;
        int index = 0;
        int time = 0;
        // 대기는 0, 나갈때는 poll
        while(!queue.isEmpty()){
            time++;
            sum -= queue.poll();
            if(sum + arr[index] <= L){
                if(index < n){
                    queue.add(arr[index]);
                    sum += arr[index++];
                }
            } else{
                queue.add(0);
            }
        }

        System.out.println(time);
        
    }  
}
