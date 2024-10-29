import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            map.put(br.readLine(), 1);
        }

        for(int i=0; i<m; i++){
            String name = br.readLine();
            if(map.getOrDefault(name, 0) == 1){
                arr.add(name);
            }
        }
        
        System.out.println(arr.size());
        Collections.sort(arr);
        for(String deutbo : arr){
            System.out.println(deutbo);
        }

    }

}
