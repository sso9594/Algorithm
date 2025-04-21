import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int w;
        int[] edge;
        
        Node(int w){
            this.w = w;
        }
    }
    static int N;
    static Node[] nodes;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            nodes[i].edge = new int[size];
            for (int j = 0; j < size; j++) {
                nodes[i].edge[j] = Integer.parseInt(st.nextToken())-1;
            }
        }

        powerSet(0, new boolean[N]);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void powerSet(int depth, boolean[] sel) {
        if(depth == N){
            calC(sel);
            return;
        }

        sel[depth] = true;
        powerSet(depth+1, sel);
        sel[depth] = false;
        powerSet(depth+1, sel);
    }

    static void calC(boolean[] sel) {

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if(sel[i]) {
                A.add(i);
            }
        }

        for (int i = 0; i < N; i++) {
            if(!sel[i]) {
                B.add(i);
            }
        }

        if(A.size() == 0 || B.size() == 0) return;

        boolean[] visitedA = new boolean[N];
        checkVertex(visitedA, A, A.get(0), 0);
        boolean[] visitedB = new boolean[N];
        checkVertex(visitedB, B, B.get(0), 0);

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            if(visitedA[i]){
                count++;
            }
            if(visitedB[i]){
                count2++;
            }
        }
        if(count != A.size()) return;
        if(count2 != B.size()) return;

        int sumA = 0;
        int sumB = 0;

        for (int num : A) {
            sumA += nodes[num].w;
        }
        for (int num : B){
            sumB += nodes[num].w;
        }

        result = Math.min(result, Math.abs(sumA-sumB));
    }

    static void checkVertex(boolean[] visitedA, List<Integer> arr, int index, int depth) {
        if(depth == N){
            return;
        }

        visitedA[index] = true;

        for (int edge : nodes[index].edge) {
            if(arr.contains(edge) && !visitedA[edge]){
                checkVertex(visitedA, arr, edge, depth);
            }
        }
    }
}
