import java.util.Scanner;

class Solution
{

    static int result;
    static int num;
    static int mult;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            num = sc.nextInt();
            mult = sc.nextInt();

            result = mult(num, mult);
            
            System.out.println("#" + test_case + " " + result);
		}
	}

    static int mult(int num, int count){
        if (count==0) {
            return 1;
        }
        return num * mult(num, count-1);
    }
}