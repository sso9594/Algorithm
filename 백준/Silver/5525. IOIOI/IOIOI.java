import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String str = sc.next();

        int result = 0;
        int count = 0;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)=='I' && i+1<str.length() && str.charAt(i+1)=='O'
            && i+2<str.length() && str.charAt(i+2)=='I'){
                count++;
                if(count == N){
                    result++;
                    count--;
                }
                i++;
            } else{
                count = 0;
            }
        }

        System.out.println(result);
        
    }
}
