import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<28; i++){
            arr[Integer.parseInt(br.readLine())] = 1;
        }
        for(int i=1; i<31; i++){
            if (arr[i]!=1){
                result.add(i);
            }
        }
        
        for(int i=0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

}
