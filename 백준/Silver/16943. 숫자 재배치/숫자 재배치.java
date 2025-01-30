import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[] arr;
    static String A;
    static int B;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.next();
        B = sc.nextInt();
        arr = new char[A.length()];
        max = -1;

        for (int i = 0; i < A.length(); i++) {
            arr[i] = A.charAt(i);
        }

        comb(new char[A.length()], 0, new boolean[A.length()]);

        System.out.println(max);
    }

    static void comb(char[] combSet, int count, boolean[] visited){
        if(count == A.length()){
            String token = "";
            for (int i = 0; i < combSet.length; i++) {
                token += combSet[i];
            }
            if(token.charAt(0)=='0') return;
            int num = Integer.parseInt(token);
            if(num < B){
                max = Math.max(max, num);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                combSet[count] = arr[i];
                comb(combSet, count+1, visited);
                visited[i] = false;
            }
        }
    }
}