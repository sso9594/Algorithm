import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String str = br.readLine();
            String result = "";

            char c = str.toCharArray()[0];
            char c1 = str.toCharArray()[str.length()-1];

            result = String.valueOf(c) + c1;

            System.out.println(result);
        }
    }
}
