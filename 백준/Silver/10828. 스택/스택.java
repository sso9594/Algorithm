import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.add(num);
                    break;
                case "top":
                    try{
                        System.out.println(stack.peek());
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "pop":
                    try{
                        int popNum = stack.pop();
                        System.out.println(popNum);
                        break;
                    }catch(Exception e){
                        System.out.println(-1);
                        break;
                    }
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                default:
                    break;
            }
        }
    }
}
