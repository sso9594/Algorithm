import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Home {
        int x, y;
        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }       
    }
    static List<Home> homes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int result = 0;

            map = new int[N][N];
            homes = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1) homes.add(new Home(i, j));
                }
            }

            int k=0;

            while (true) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int count = countHouse(i, j, k);
                        int calc = count * M - (k*k+(k-1)*(k-1));
                        if(calc >= 0){
                            result = Math.max(result, count);
                        }
                    }
                }
                if(k>=N && k%2!=0){
                    break;
                }
                k++;
            }
            
            System.out.println("#" + test_case + " " + result);
        }
    }

    // 해당 칸에 몇개의 집이 들어가있는지 반환
    static int countHouse(int x, int y, int k){
        int count = 0;
        for (Home home : homes) {
            if(calcDistance(home, x, y) <= k-1){
                count++;
            }
        }
        
        return count;
    }

    static int calcDistance(Home home, int x, int y){
        return Math.abs(home.x - x) + Math.abs(home.y - y);
    }
}
