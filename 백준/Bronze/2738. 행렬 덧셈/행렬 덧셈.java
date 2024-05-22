import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num1 = Integer.parseInt(st1.nextToken());
                a.add(num1);
            }

        }

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                int num1 = Integer.parseInt(st2.nextToken());
                b.add(num1);
            }

        }
        
        for(int i=0; i<n*m; i++){
            c.add(a.get(i) + b.get(i));
        }

        for(int i=0; i<n*m; i++){
            System.out.print(c.get(i) + " ");
            if ((i+1)%m==0){
                System.out.println();
            }
        }
    }

}
