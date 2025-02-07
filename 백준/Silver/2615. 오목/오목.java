import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 상/하/좌/우/우상/우하/좌상/좌하
    static int[][] baduk;
    static int[] dx = {-1,1,0,0,-1,1};
    static int[] dy = {0,0,-1,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        baduk = new int[21][21];

        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                baduk[i][j] = Integer.parseInt(st.nextToken()+"");
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if(baduk[i][j]!=0 && isWin(i, j)){
                    System.out.println(baduk[i][j]);
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

        System.out.println(0);
        
    }

    static boolean isWin(int x, int y){
        for (int i = x; i < baduk.length; i++) {
            for (int j = y; j < baduk.length; j++) {
                int color = baduk[i][j];
                // 해당 자리 8방향 탐색
                for (int direct = 0; direct < dx.length; direct++) {
                    int same = 0;
                    // 해당 방향 탐색
                    for (int count = 0; x+count*dx[direct]<baduk.length-1 && y+count*dy[direct]<baduk.length-1
                    && x+count*dx[direct]>=0 && y+count*dy[direct]>=0 && count<5; count++) {
                        
                        if(color==baduk[x+count*dx[direct]][y+count*dy[direct]]){
                            same++;
                            if(same==5){
                                if(x>0 && y>0 && baduk[x-dx[direct]][y-dy[direct]]!=color
                                && baduk[(x+(count+1)*dx[direct])][(y+(count+1)*dy[direct])]!=color){
                                    return true;
                                }
                            }
                        }
                    }
                }
                
            }
        }

        return false;
    }
}
