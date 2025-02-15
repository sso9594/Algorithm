import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("Sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] trees = new int[N];
            int[] diff = new int[N];

            int max = 0;
            int sum = 0;
            int day = 0;

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }

            for (int i = 0; i < N; i++) {
                diff[i] = max - trees[i];
                sum += diff[i];
            }

            day = (sum / 3) * 2;

            if(sum%3==1) day++;
            else if (sum%3==2) day+=2;

            int even = 0;

            for (int i = 0; i < diff.length; i++) {
                even += diff[i] / 2;
            }

            if(sum > even * 3){
                day = even * 2;
            }

            int remain = sum - even * 3;

            if(remain>0){
                day+=remain*2-1;
            }

            System.out.println("#" + test_case + " " + day);
        }
    }
}
