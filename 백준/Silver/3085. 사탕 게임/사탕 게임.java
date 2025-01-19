import java.util.*;

public class Main{

    static char[][] arr;
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        for(int i=0; i<N; i++){
            String token = sc.next();
            for(int j=0; j<N; j++){
                arr[i][j] = token.charAt(j);
            }
        }

        int max = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j<N-1){
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;

                    max = Math.max(max, countArrSame());

                    temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                }

                if(i<N-1){
                    char temp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = temp;

                    max = Math.max(max, countArrSame());

                    temp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = temp;
                }
            }
        }

        System.out.println(max);
    }

    static int countArrSame(){
        int max = 1;
        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=1; j<N; j++){
                if(arr[i][j] == arr[i][j-1]){
                    count++;
                    max = Math.max(max, count);
                } else{
                    count = 1;
                }
            }
            count = 1;
            for(int j=1; j<N; j++){
                if(arr[j][i] == arr[j-1][i]){
                    count++;
                    max = Math.max(max, count);
                } else{
                    count = 1;
                }
            }
        }

        return max;
    }

}