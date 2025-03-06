import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BC[] chargers;
    static int[] moveA;
    static int[] moveB;
    static Position pA;
    static Position pB;
    static int M;
    static int A;
    static int result;
    static class BC{
        int x, y, c, p;
        BC(int x, int y, int c, int p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        public boolean equals(int x, int y) {
            // TODO Auto-generated method stub
            return this.x == x && this.y == y;
        }
    }
    static class Position {
        int x, y;
        Position(int x, int y){
            this.x = x;
            this.y= y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            
            moveA = new int[M];
            moveB = new int[M];
            pA = new Position(0, 0);
            pB = new Position(9, 9);
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            chargers = new BC[A];

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                chargers[i] = new BC(x, y, c, p);
            }

            for (int i = 0; i <= M; i++) {
                bestCharge();
                if(i<M){
                    move(i);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    /*
     * A와 B가 어느 충전소에서 충전하는지 최대값
     * 먼저 어떤 충전소에 가능한지 확인해보고?
     * 
     */
    static void bestCharge(){
        int max  = 0;
        boolean[] canA = new boolean[A];
        boolean[] canB = new boolean[A];
        for (int i=0; i<chargers.length; i++) {
            canA[i] = canCharge(chargers[i], pA);
            canB[i] = canCharge(chargers[i], pB);
        }

        for (int i = 0; i < A; i++) {
            int sum = 0;
            if(canA[i]){
                sum += chargers[i].p;
                max = Math.max(max, sum);
            }
            for (int j = 0; j < A; j++) {
                if(i==j && canB[j] && canA[i]){
                    continue;
                } else if(canB[j]){
                    sum += chargers[j].p;
                    max = Math.max(max, sum);
                    sum -= chargers[j].p;
                    continue;
                }
            }
        }

        result += max;
    }

    static void move(int time){
        int ACommnad = moveA[time];
        int BCommnad = moveB[time];

        pA.x += findDirection(ACommnad)[0];
        pA.y += findDirection(ACommnad)[1];

        pB.x += findDirection(BCommnad)[0];
        pB.y += findDirection(BCommnad)[1];


    }

    static boolean canCharge(BC bc, Position p){
        int d = Math.abs(bc.x-p.x) + Math.abs(bc.y-p.y);
        if(d <= bc.c){
            return true;
        } else{
            return false;
        }
    }

    static int[] findDirection(int command){
        switch (command) {
            case 0:
                return new int[]{0,0};
            case 1:
                return new int[]{-1,0};
            case 2:
                return new int[]{0,1};
            case 3:
                return new int[]{1,0};
            case 4:
                return new int[]{0,-1};
            default:
                break;
        }

        return null;
    }
}
