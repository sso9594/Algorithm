import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String line = br.readLine();
            if(line.equals(".")){
                break;
            }
            if(isBalanced(line)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }
    }

    private static boolean isBalanced(String line){
        Stack<Character> stack = new Stack<>();

        for(char ch : line.toCharArray()){
            if(ch == '(' || ch == '['){
                stack.push(ch);
            }
            else if(ch == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
            else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
