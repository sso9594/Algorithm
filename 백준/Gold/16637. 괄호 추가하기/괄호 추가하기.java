import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int max;
    static char[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;

        arr = new char[N];
        String token = br.readLine();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = token.charAt(i);
        }

        dfs(1, Integer.parseInt(arr[0]+""));

        System.out.println(max);

    }

    static void dfs(int index, int result){
        if(index>=N){
            max = Math.max(max, result);
            return;
        }
        // 현재 순번이 연산자인 경우에만 계산
        //괄호 미부여 (바로 계산)
        dfs(index+2, calc(result, Integer.parseInt(arr[index+1]+""), arr[index]));
        //괄호 부여
        if(index<N-2){
            int currentResult = calc(Integer.parseInt(arr[index+1]+""), Integer.parseInt(arr[index+3]+""), arr[index+2]);
            dfs(index+4, calc(result, currentResult, arr[index]));
        }

    }

    static int calc(int num1, int num2, char operation){
        switch (operation) {
            case '+':
                return num1 + num2;    
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                break;
        }
        return 0;
    }

}