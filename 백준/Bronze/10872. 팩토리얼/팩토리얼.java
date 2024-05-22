import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        System.out.println(factorial(a));
        
    }
    private static int factorial(int n){
        int result = 1;
        if(n >= 1){
            result = n * factorial(n-1);
        }
        return result;
    }
}
