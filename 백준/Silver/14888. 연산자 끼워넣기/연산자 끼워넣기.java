import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int max;
    static int min;
    static int[] arr;
    static int[] operation;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        // 0은 더하기, 1은 빼기, 3은 곱하기, 4는 나누기
        operation = new int[4];
        
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            operation[i] = sc.nextInt();
        }

        dfs(1, arr[0], 0);
    
        System.out.println(max);
        System.out.println(min);

    }  

    static void dfs(int count, int sum, int operationNum){
        if(count>=N){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int j=0; j<4; j++){
            if(operation[j]==0){
                continue;
            }
            sum = operate(sum, count, j);
            dfs(count+1, sum, j);
            sum = deoperate(sum, count, j);
        }
        
    }

    static int operate(int sum, int count, int operationNum){
        if(operationNum==0 && operation[operationNum] > 0){
            sum += arr[count];
            operation[operationNum]--;
        } else if(operationNum==1 && operation[operationNum] > 0){
            sum -= arr[count];
            operation[operationNum]--;
        } else if(operationNum==2 && operation[operationNum] > 0){
            sum *= arr[count];
            operation[operationNum]--;
        } else if(operationNum==3 && operation[operationNum] > 0){
            sum /= arr[count];
            operation[operationNum]--;
        } 

        return sum;
    }

    static int deoperate(int sum, int count, int operationNum){
        if(operationNum==0){
            sum -= arr[count];
            operation[operationNum]++;
        } else if(operationNum==1){
            sum += arr[count];
            operation[operationNum]++;
        } else if(operationNum==2){
            sum /= arr[count];
            operation[operationNum]++;
        } else{
            sum *= arr[count];
            operation[operationNum]++;
        }

        return sum;
    }
}
