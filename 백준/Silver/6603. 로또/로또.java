import java.util.*;

public class Main{
    static int[] lotto;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int k = sc.nextInt();
            if(k==0){
                break;
            }
            lotto = new int[k];
            for(int i=0; i<k; i++){
                lotto[i] = sc.nextInt();
            }

            dfs(0, new ArrayList<>(), 0);
            System.out.println("");
        }
    }

    // dfs를 통해 가능한 모든 경우의 수 탐색
    static void dfs(int depth, ArrayList<Integer> arr, int start){
        // 조합 6개가 전부 모아지면 출력
        if(depth==6){
            for(int index=0; index<6; index++){
                System.out.print(arr.get(index) + " ");
            }
            System.out.println("");
            return;
        }

        // 한 자리에 하나씩 대입 해보며 탐색
        // 다음 조합은 다음 숫자부터 하도록 i = start
        for(int i=start; i<lotto.length; i++){
            arr.add(lotto[i]);
            dfs(depth+1, arr, i+1);
            arr.remove(arr.size()-1);
        }
    }
}