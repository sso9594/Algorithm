import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> n_arr = new HashMap<Integer, Integer>();
        ArrayList<Integer> m_arr = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int key = Integer.parseInt(st.nextToken());
            n_arr.put(key, n_arr.getOrDefault(key, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int key = n_arr.getOrDefault(Integer.parseInt(st2.nextToken()), 0);
            m_arr.add(key);
        }
        
        for(int num : m_arr){
            bw.write(num + " ");
        }
        bw.flush();
    
    }
}
