import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int max = 0;
        int aS = -1;
        int aT = -1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(arr[i].equals(arr[j])) continue;

                int len = compare(arr[i], arr[j]);

                if (len > max) {
                    max = len;
                    aS = i;
                    aT = j;
                } else if (len == max && len > 0) {
                    if (aS == -1 || i < aS || (i == aS && j < aT)) {
                        aS = i;
                        aT = j;
                    }
                }
            }
        }

        System.out.println(arr[aS]);
        System.out.println(arr[aT]);
    }

    static int compare(String s1, String s2){
        int len = Math.min(s1.length(), s2.length());
        int idx = 0;
        while (idx < len && s1.charAt(idx) == s2.charAt(idx)){
            idx++;
        }

        return idx;
    }

}
