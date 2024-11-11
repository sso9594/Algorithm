import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String N = sc.next();
            int max = 0;
            char[][] arr = new char[100][100];
            for(int i=0; i<100; i++){
                String token = sc.next();
                for(int j=0; j<100; j++){
                    arr[i][j] = token.charAt(j);
                }
            }
            
            //가로 검사
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    for(int q=99; q>=j; q--){
                        String token = "";
                        for(int k=j; k<q; k++){
                            token += arr[i][k];
                        }
                        if(check(token)){
                            max = Math.max(max, q-j);
                        }
                    }
                }
            }
            // 세로 검사
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    for(int q=99; q>=j; q--){
                        String token = "";
                        for(int k=j; k<q; k++){
                            token += arr[k][i];
                        }
                        if(check(token)){
                            max = Math.max(max, q-j);
                        }
                    }
                }
            }
            
            System.out.println("#" + N + " " + max);
		}
	}
    
    static boolean check(String token){
        int left = 0;
        int right = token.length() - 1;
        while(left < right){
            if(token.charAt(left) != token.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}