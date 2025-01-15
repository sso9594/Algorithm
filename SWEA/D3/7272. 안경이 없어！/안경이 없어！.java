import java.util.*;
import java.io.*;

class Solution
{
    static String no_hole = "CEFGHIJKLMNSTUVWXYZ";
    static String one_hole = "ADOPQR";
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str1 = sc.next();
            String str2 = sc.next();
            boolean isSame = true;

            if(str1.length()!=str2.length()){
                System.out.println("#" + test_case + " " + "DIFF");
                continue;
            }

            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i)=='B'){
                    if(str2.charAt(i)=='B'){
                        continue;
                    } else{
                        isSame = false;
                        break;
                    }
                } else if(str2.charAt(i)=='B'){
                    if(str1.charAt(i)=='B'){
                        continue;
                    } else{
                        isSame = false;
                        break;
                    }
                }
                boolean str1_isHole = false;
                boolean str2_isHole = false;
                
                if(one_hole.contains(str1.charAt(i)+"")){
                    str1_isHole = true;
                }

                if(one_hole.contains(str2.charAt(i)+"")){
                    str2_isHole = true;
                }

                if(str1_isHole!=str2_isHole){
                    isSame = false;
                    break;
                }
            }

            if(isSame){
                System.out.println("#" + test_case + " " + "SAME");
            } else{
                System.out.println("#" + test_case + " " + "DIFF");
            }
		}
	}
}