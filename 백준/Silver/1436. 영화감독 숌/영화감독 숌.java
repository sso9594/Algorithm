import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 666;
        while(count < n){
            if (String.valueOf(number).contains("666")){
                count++;
            }
            number++;
        }
        System.out.println(number-1);
    }
}
