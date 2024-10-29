import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
            for(int j=0; j<i; j++){
                sum += arr.get(j);
            }
        }

        System.out.println(sum);
    }

}
