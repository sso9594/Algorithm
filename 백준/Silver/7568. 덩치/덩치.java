import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            ArrayList<Integer> person = new ArrayList<>();
            person.add(weight);
            person.add(height);
            arr.add(person);
        }

        for(int i=0; i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                if (arr.get(i).get(0) < arr.get(j).get(0)){
                    if(arr.get(i).get(1) < arr.get(j).get(1)){
                        rank++;
                    }
                }
            }

            System.out.print(rank + " ");
        }
    }
}
