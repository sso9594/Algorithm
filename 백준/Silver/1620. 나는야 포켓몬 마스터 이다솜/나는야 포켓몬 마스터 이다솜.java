import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> dogam = new HashMap<>();
        HashMap<String, Integer> dogam1 = new HashMap<>();

        for(int i=0; i<n; i++){
            String target = br.readLine();

            dogam.put(i+1, target);
            dogam1.put(target, i+1);
        }

        for(int i=0; i<m; i++){
            String question = br.readLine();

            if(question.chars().allMatch(Character::isLetter)){
                bw.write(dogam1.getOrDefault(question, null) + "\n");
            }
            else if(question.chars().allMatch(Character::isDigit)){
                bw.write(dogam.getOrDefault(Integer.parseInt(question), null) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
