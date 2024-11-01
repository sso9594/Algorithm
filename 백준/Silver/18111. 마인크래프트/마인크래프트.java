import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int minH = Integer.MAX_VALUE;
        int maxH = 0;
        int minT = Integer.MAX_VALUE;
        int height = 0;
        int[][] ground = new int[N][M];

        for(int i=0; i<N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st1.nextToken());
                ground[i][j] = num;
                minH = Math.min(num, minH);
                maxH = Math.max(num, maxH);
            }
        }

        for(int i = minH; i<=maxH; i++){
            int time = 0;
            int inven = B;
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    int standH = ground[j][k];
                    if(standH > i){
                        int remove = standH - i;
                        time += 2 * remove;
                        inven += remove;
                    } else if(standH < i){
                        int add = i - standH;
                        time += add;
                        inven -= add;
                    }
                }
            }

            if(inven>=0){
                if(time < minT || (time == minT && i > height)){
                    minT = time;
                    height = i;
                }
            }
        }

        System.out.println(minT + " " + height);

    }

}
