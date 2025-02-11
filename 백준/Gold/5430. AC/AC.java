import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();
            String token = br.readLine();
            token = token.replace("[", "");
            token = token.replace("]", "");
            // 숫자가 있는경우
            if(token!=""){
                String[] tokens = token.split(",");
                short isRevere = -1;
                boolean isValid = true;
                for (int i = 0; i < tokens.length; i++) {
                    deque.add(Integer.parseInt(tokens[i]));
                }
                for (int i = 0; i < command.length(); i++) {
                    if(command.charAt(i)=='R'){
                        isRevere *= -1;
                    } else if(command.charAt(i)=='D'){
                        if (deque.size()<=0) {
                            isValid = false;
                        }
                        if(isRevere==-1){
                            deque.pollFirst();
                        } else{
                            deque.pollLast();
                        }
                    }
                }
                if (!isValid) {
                    System.out.println("error");
                    continue;
                }
                if(deque.size()<=0){
                    System.out.println("[]");
                    continue;
                }
                if(isRevere==-1){
                    int size = deque.size();
                    System.out.print("[");
                    for (int i = 0; i < size-1; i++) {
                        System.out.print(deque.pollFirst() + ",");
                    }
                    System.out.println(deque.pollFirst()+"]");
                } else{
                    int size = deque.size();
                    System.out.print("[");
                    for (int i = 0; i < size-1; i++) {
                        System.out.print(deque.pollLast() + ",");
                    }
                    System.out.println(deque.pollLast()+"]");
                }
            // 공백 배열인 경우
            } else{
                boolean isValid = true;
                for (int i = 0; i < command.length(); i++) {
                    if(command.charAt(i)=='D'){
                        isValid = false;
                    }
                }
                if (isValid) {
                    System.out.println("[]");
                } else{
                    System.out.println("error");
                }
            }

        }
    }

}