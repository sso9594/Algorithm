import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            char[] charArr = str.toCharArray();

            int count = 0;
            for (char target : charArr){
                if(target == '('){
                    count += 1;
                }
                else{
                    count -= 1;
                }
                if(count < 0){
                    System.out.println("NO");
                    break;
                }
            }
            if(count == 0){
                System.out.println("YES");
            }
            else if(count >= 0){
                System.out.println("NO");
            }
        }
        
    }
}
