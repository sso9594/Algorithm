import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static int[][] adjMat;
    static ArrayList<ArrayList<Integer>> powerSet;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N];
        powerSet = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < population.length; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        adjMat = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int v = Integer.parseInt(st.nextToken())-1;
                adjMat[i][v]=1;
                adjMat[v][i]=1;
            }
        }

        powerSet(0, 0, new ArrayList<>());

        for (ArrayList<Integer> set : powerSet) {
            visited = new boolean[N];
            // set 집합 도달 가능 여부 확인
            checkVertex(set.get(0), set);

            // list와 반대되는 집합
            ArrayList<Integer> opposite = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                opposite.add(i);
            }
            for (int i = 0; i < set.size(); i++) {
                for (int j = 0; j < opposite.size(); j++) {
                    if(opposite.get(j).equals(set.get(i))){
                        opposite.remove(j);
                    }
                }
            }

            // 반대 집합 도달 가능 여부 확인
            checkVertex(opposite.get(0), opposite);

            // 모든 visited가 true이면 계산 가능
            boolean valid = true;
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]) valid = false;
            }
            
            // 최소값 계산
            if(valid){
                int setSum = 0;
                int oppSum = 0;
                for (int i = 0; i < set.size(); i++) {
                    setSum += population[set.get(i)];
                }
                for (int i = 0; i < opposite.size(); i++) {
                    oppSum += population[opposite.get(i)];
                }

                min = Math.min(min, Math.abs(setSum-oppSum));
            } 

        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    // 도달 여부 조사 함수, 도달 하더라도, list에 없는 정점은 방문처리 하면 안됨
    static void checkVertex(int v, ArrayList<Integer> list){
        if(visited[v]){
            return;
        }

        visited[v] = true;

        for (int i = 0; i < adjMat[v].length; i++) {
            if(adjMat[v][i]==1 && list.contains(i)){
                checkVertex(i, list);
            }
        }

        return;
    }

    static void powerSet(int index, int depth, ArrayList<Integer> sel){
        if(index==N){
            if(sel.size()!=0 && sel.size()!=N){
                ArrayList<Integer> copy = new ArrayList<>(sel);
                powerSet.add(copy);
            }
            return;
        }

        powerSet(index+1, depth, sel);

        sel.add(depth, index);
        powerSet(index+1, depth+1, sel);
        sel.remove(depth);
    }
}
/*
 * 파워셋(인데 모든 정점이 포함되어있는 세트)을 전부 뽑아서 해당 세트 전부 dfs로 연결되어있는지 확인
 * 전부 연결되어있으면 연결된 각 부분들의 합 계산 후 최소값 계산
 * 파워셋을 뽑고 포함되지 않은 정점은 다른 세트에 두면 됨
 */
