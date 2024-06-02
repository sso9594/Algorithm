import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int sum = 0;

        int flat = (int) Math.round(arr.size() * 0.15);

        if (n != 0){
            for(int i = flat; i < arr.size() - flat; i++){
                sum += arr.get(i);
            }
            double mean = (double) sum / (arr.size() - 2 * flat);
            System.out.println((int)Math.round(mean));

        }
        else{
            System.out.println(0);
        }
    }

}
