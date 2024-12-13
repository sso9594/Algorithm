import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++){
            int result = -1;

            int M = sc.nextInt();
            int N = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();

            int j = 0;
            int num = x + (M * j);
            int lcm = lcm(M, N);

            for (; num <= lcm; num += M) {
                if ((num - 1) % N + 1 == y) {
                    result = num;
                    break;
                }
            }

            System.out.println(result);
            
        }

    }

    

    static int lcm(int x, int y){
        return x * y / gcd(x, y);
    }

    static int gcd(int x, int y){
        while(y != 0){
            int r = y;
            y = x % y;
            x = r;
        }

        return x;
    }
}
