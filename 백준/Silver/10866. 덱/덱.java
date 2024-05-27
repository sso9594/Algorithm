import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case "push_back":
                    int num1 = Integer.parseInt(st.nextToken());
                    deque.addLast(num1);
                    break;
                case "front":
                    try{
                        System.out.println(deque.getFirst());
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "back":
                    try{
                        System.out.println(deque.getLast());
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "pop_front":
                    try{
                        int popNum = deque.removeFirst();
                        System.out.println(popNum);
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "pop_back":
                    try{
                        int popNum = deque.removeLast();
                        System.out.println(popNum);
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                default:
                    break;
            }
        }
    }
}
