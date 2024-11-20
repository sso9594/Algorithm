import java.util.*;

public class Main {
    static int[][] arr;       
    static boolean[] result; 
    static int N;             

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++) { 
            for (int i = 0; i < N; i++) { 
                for (int j = 0; j < N; j++) { 
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1; 
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
