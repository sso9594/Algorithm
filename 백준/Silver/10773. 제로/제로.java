import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input != 0){
                stack.add(input);
            }
            else{
                stack.pop();
            }
        }
        int sum = 0;
        for(int num : stack){
            sum += num;
        }

        System.out.println(sum);
        
    }

}
