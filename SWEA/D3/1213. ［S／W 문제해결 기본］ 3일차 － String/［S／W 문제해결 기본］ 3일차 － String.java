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
            String token = sc.next();
            String str = sc.next();
            int count = 0;

            for(int i=0; i<str.length()-token.length()+1; i++){
                boolean valid = true;
                for(int j=0; j<token.length(); j++){
                    if(str.charAt(i+j) != token.charAt(j)){
                        valid = false;
                    }
                }
                if(valid){
                    count++;
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}