import java.util.*;

public class Main {
    static int N;
    static int[] roma = {1,5,10,50};
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        set = new HashSet<>();
        dupliComb(0, 0, 0);

        System.out.println(set.size());
    }

    static void dupliComb(int sel, int depth, int index){
        if(N == depth){
            set.add(sel);
            return;
        }

        for (int i = index; i < roma.length; i++) {
            dupliComb(sel+roma[i], depth+1, i);
        }
        
    }
}
