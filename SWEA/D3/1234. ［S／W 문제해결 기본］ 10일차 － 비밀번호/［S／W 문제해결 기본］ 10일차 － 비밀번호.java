import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String password = sc.next();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < password.length(); i++) {
                arr.add(Integer.parseInt(password.charAt(i)+""));
            }

            while(true){
                boolean isvalid = true;
                for (int i = 0; i < arr.size()-1; i++) {
                    if(arr.get(i)==arr.get(i+1)){
                        for (int j = 0; j < 2; j++) {
                            arr.remove(i);
                        }
                        isvalid = false;
                        break;
                    }
                }
                if(isvalid){
                    break;
                }
            }

            String result = "";

            for (int num : arr) {
                result += num;
            }
            
            System.out.println("#" + test_case + " " + result);
        }
    }
}
