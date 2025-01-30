import java.util.Scanner;

public class Main {

    static int[] card;
    static int N;
    static int M;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        max = 0;

        comb(0, 0, 0);

        System.out.println(max);
    }

    static void comb(int index, int sum, int depth){
        if (depth == 3) { 
            if (sum <= M) {
                max = Math.max(sum, max);
            }
            return;
        }
    
        if (index >= N) {
            return;
        }

        comb(index+1, sum+card[index], depth+1);
        comb(index+1, sum, depth);
    }
}
