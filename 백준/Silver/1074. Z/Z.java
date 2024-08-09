import java.io.*;
import java.util.*;

public class Main {
    static int R = 0;
    static int C = 0;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        solution(0, 0, (int) Math.pow(2, n));
        System.out.println(result);
    }

    static void solution(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int currentSize = size / 2;
        if (R < r + currentSize && C < c + currentSize) {
            // 1사분면
            solution(r, c, currentSize);
        } else if (R < r + currentSize && C >= c + currentSize) {
            // 2사분면
            result += (currentSize * currentSize);
            solution(r, c + currentSize, currentSize);
        } else if (R >= r + currentSize && C < c + currentSize) {
            // 3사분면
            result += (currentSize * currentSize) * 2;
            solution(r + currentSize, c, currentSize);
        } else if (R >= r + currentSize && C >= c + currentSize) {
            // 4사분면
            result += (currentSize * currentSize) * 3;
            solution(r + currentSize, c + currentSize, currentSize);
        }
    }
}
