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
            String token = sc.next();

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i=0; i<N; i++){
                arr.add(Integer.parseInt(token.charAt(i)+""));
            }
            while(true){
                boolean valid = true;
                for(int i=0; i<arr.size()-1; i++){
                    if(isSequence(arr, i)){
                        for(int j=0; j<2; j++){
                            arr.remove(i);
                        }
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    break;
                }
            }

            System.out.print("#" + test_case + " ");
            for(int num : arr){
                System.out.print(num);
            }
            System.out.println("");
            
		}
	}

    static boolean isSequence(ArrayList<Integer> arr, int i){
        if(arr.get(i)==arr.get(i+1)){
            return true;
        }
        return false;
    }

}