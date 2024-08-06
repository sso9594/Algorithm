import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        List<Character> ans = new ArrayList<>();
        boolean find = true;
        int count = 1;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            while(count <= num){
                stack.push(count);
                ans.add('+');
                count += 1;
            }
            if(stack.peek() == num){
                stack.pop();
                ans.add('-');
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        for(char symbol : ans){
            System.out.println(symbol);
        }

    }
}
