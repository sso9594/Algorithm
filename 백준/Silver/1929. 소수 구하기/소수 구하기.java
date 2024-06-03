import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean isSosu = false;

        for(int i = m; i <= n; i++){
            if(i>3){
                for(int j = 2; j <= Math.sqrt(i); j++){
                    isSosu = false;
                    if(i % j==0){
                        break;
                    }
                    isSosu = true;
                }
            }else{
                if(i==2){
                    bw.write(String.valueOf(2 + "\n"));
                }
                if(i==3){
                    bw.write(String.valueOf(3 + "\n"));
                }
            }
            if(isSosu){
                bw.write(String.valueOf(i + "\n"));
            }
        }

        bw.flush();
        bw.close();

    }

}
