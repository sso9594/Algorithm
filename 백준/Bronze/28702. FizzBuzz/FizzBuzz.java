import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();
        
        int start = -1;
        if(isNumber(input1)){
            start = Integer.parseInt(input1);
        }else if(isNumber(input2)){
            start = Integer.parseInt(input2) - 1;
        }else if(isNumber(input3)){
            start = Integer.parseInt(input3) - 2;
        }

        if(start != -1){
            while(true){
                if(fizzBuzz(start).equals(input1) &&
                fizzBuzz(start + 1).equals(input2) &&
                fizzBuzz(start + 2).equals(input3)){
                    break;
                }
                start++;
            }
        }

        System.out.println(fizzBuzz(start + 3));
        
    }
    private static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(Exception e){
            return false;
        }
        
    }

    private static String fizzBuzz(int num){
        if(num % 5 == 0 && num % 3 ==0){
            return "FizzBuzz";
        }
        else if(num % 5==0){
            return "Buzz";
        }
        else if(num % 3==0){
            return "Fizz";
        }
        else{
            return Integer.toString(num);
        }
    }

}
