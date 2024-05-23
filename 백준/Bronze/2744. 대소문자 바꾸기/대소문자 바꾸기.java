import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";

        for(char c : str.toCharArray()){
            if (Character.isUpperCase(c)){
                result += Character.toLowerCase(c);
            }
            else{
                result += Character.toUpperCase(c);
            }
            
        }
        
        System.out.println(result);
    }

}
