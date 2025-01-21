import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] result = new int[n];

        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            while (!stack.isEmpty() && stack.peek()[1] <= num) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1;
            }
            
            stack.push(new int[]{i, num});
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(result[i]+ " ");
        }        

        bw.flush();
        br.close();
        bw.close();
    }
}