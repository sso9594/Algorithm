import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] coord = new int[N];
        for(int i=0; i<N; i++){
            coord[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for(int num : coord){
            set.add(num);
        }

        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.size(); i++){
            map.put(arr.get(i), i);
        }

        for(int i=0; i<N; i++){
            bw.write(map.get(coord[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
