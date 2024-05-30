import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 0;
        int result = -1;
        while(5*i<=n){
            if((n-(5*i))%3==0){
                int f_bag = i;
                int t_bag = (n-(5*i)) / 3;
                if(result == -1 || (f_bag+t_bag)<result){
                    result = f_bag + t_bag;
                }
            }
            i++;
        }
        if(result == 5000){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
        
        
    }

}
