import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {    
    static int N,W,H;
    static int[][] originMap;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            originMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    originMap[i][j] = Integer.parseInt(st.nextToken());    
                }
            }

            permu(0, new int[N]);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void permu(int depth, int[] sel){
        if(depth==N){
            // 시뮬 로직
            int[][] copy = deepCopy();
            simulation(copy, sel);
            return;
        }

        for (int i = 0; i < W; i++) {
            sel[depth] = i;
            permu(depth+1, sel);
        }
    }

    static void simulation(int[][] map, int[] sel) {
        int result = 0;
        for (int i = 0; i < sel.length; i++) {
            int tarCol = sel[i];
            int tarRow = 0;
            for (int j = 0; j < H; j++) {
                if(map[j][tarCol]!=0){
                    tarRow = j;
                    break;
                }
            }

            // 해당 벽돌 폭파
            breakBrick(map, tarRow, tarCol);
            // 맵 정리(중력 적용)
            result = gravity(map);
        }
        answer = Math.min(result, answer);
    }

    static int gravity(int[][] map) {
        int count = 0;
        for (int i = 0; i < W; i++) {
            Stack<Integer> elements = new Stack<>();
            for (int j = 0; j < H; j++) {
                if(map[j][i]>0) elements.add(map[j][i]);
            }
            count += elements.size();
            for (int j = H-1; j >=0; j--) {
                if(!elements.isEmpty()){
                    map[j][i] = elements.pop();
                } else{
                    map[j][i] = 0;
                }
            }
        }
        return count;
    }

    static void breakBrick(int[][] map, int r, int c) {
        int pivot = map[r][c];
        map[r][c] = 0;
        
        for (int i = 0; i < pivot; i++) {
            for (int j = 0; j < dx.length; j++) {
                int nr = r + dx[j] * i;
                int nc = c + dy[j] * i;

                if(nr>=0 && nc>=0 && nr<H && nc<W){
                    breakBrick(map, nr, nc);
                }
            }
        }
    }

    static int[][] deepCopy() {
        int[][] copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            copy[i] = Arrays.copyOf(originMap[i], originMap[i].length);
        }

        return copy;
    }
}
