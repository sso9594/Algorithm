import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        
        int digitResult = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
        String sum = a+b;
        int stringResult = Integer.parseInt(sum) - Integer.parseInt(c);

        System.out.println(digitResult);
        System.out.println(stringResult);

    }

}
