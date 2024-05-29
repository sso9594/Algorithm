import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            ArrayList<Integer> coor = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            coor.add(a);
            coor.add(b);

            arr.add(coor);
        }

        arr.sort((o1, o2) -> {
            int compare = o1.get(1).compareTo(o2.get(1));
            if(compare != 0){
                return compare;
            }
            else{
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        for (ArrayList<Integer> coor : arr) {
            System.out.println(coor.get(0) + " " + coor.get(1));
        }

    }

}
