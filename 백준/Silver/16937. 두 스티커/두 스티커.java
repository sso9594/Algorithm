import java.util.Scanner;

public class Main {
    static int H;
    static int W;
    static int N;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        int max = 0;

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                max = Math.max(max, maxArea(arr[i][0], arr[i][1], arr[j][0], arr[j][1]));
                max = Math.max(max, maxArea(arr[i][0], arr[i][1], arr[j][1], arr[j][0]));
                max = Math.max(max, maxArea(arr[i][1], arr[i][0], arr[j][0], arr[j][1]));
                max = Math.max(max, maxArea(arr[i][1], arr[i][0], arr[j][1], arr[j][0]));
            }
        }

        System.out.println(max);
        
    }

    static int maxArea(int x1, int y1, int x2, int y2){
        int area = 0;
        if (Math.max(x1, x2) <= H && (y1 + y2) <= W) {
            area = Math.max(area, x1 * y1 + x2 * y2);
        }
        if (Math.max(y1, y2) <= W && (x1 + x2) <= H) {
            area = Math.max(area, x1 * y1 + x2 * y2);
        }
        if ((x1 + x2) <= H && Math.max(y1, y2) <= W) {
            area = Math.max(area, x1 * y1 + x2 * y2);
        }
        if ((y1 + y2) <= H && Math.max(x1, x2) <= W) {
            area = Math.max(area, x1 * y1 + x2 * y2);
        }

        return area;
    }
}
