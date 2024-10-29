import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            map.put(st1.nextToken(), st1.nextToken());
        }
        for(int i=0; i<M; i++){
            arr.add(map.getOrDefault(br.readLine(), ""));
        }
        for(String str : arr){
            System.out.println(str);
        }
    }

}
