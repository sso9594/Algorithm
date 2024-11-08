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
            int N = sc.nextInt();
            char[][] letter = new char[8][8];
            int count = 0;
            for(int i=0; i<8; i++){
                String token = sc.next();
                for(int j=0; j<8; j++){
                    letter[i][j] = token.charAt(j);
                }
            }

            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(j+N<=8){
                        String token = "";
                        for(int x=j; x<j+N; x++){
                            token += letter[i][x];
                        }
                        if (check(token)) {
                            count++;
                        }
                    }
                    if(i+N<=8){
                        String token = "";
                        for(int y=i; y<i+N; y++){
                            token += letter[y][j];
                        }
                        if (check(token)) {
                            count++;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);

		}
	}

    static boolean check(String token){
        int length = token.length();
        String before = "";
        String after = "";
        if(length%2==0){
            for(int i=0; i<length/2; i++){
                before += token.charAt(i);
            }
            for(int i=length-1; i>=length/2; i--){
                after += token.charAt(i);
            }
            return before.equals(after);
        } else{
            for(int i=0; i<length/2; i++){
                before += token.charAt(i);
            }
            for(int i=length-1; i>=length/2+1; i--){
                after += token.charAt(i);
            }
            return before.equals(after);
        }
    }
}