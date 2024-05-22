import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bw.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(bw.readLine());

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int v = Integer.parseInt(bw.readLine());

        int count = 0;

        for(int i=0; i<n; i++){
            if(arr.get(i) == v){
                count++;
            }
        }

        System.out.println(count);
    }

}
