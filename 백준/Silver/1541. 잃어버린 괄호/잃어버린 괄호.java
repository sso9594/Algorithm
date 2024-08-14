import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        
        int sum=Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int temp = 0;
            StringTokenizer st1 = new StringTokenizer(st.nextToken(),"+");
            while(st1.hasMoreTokens()){
                temp += Integer.parseInt(st1.nextToken());
            }

            if(sum==Integer.MAX_VALUE){
                sum = temp;
            }
            else{
                sum -= temp;
            }
        }

        System.out.println(sum);

    }

}
