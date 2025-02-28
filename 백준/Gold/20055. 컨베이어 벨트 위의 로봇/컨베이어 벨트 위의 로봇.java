import java.util.Scanner;

public class Main {
    static int[] conveyor;
    static int[] robots;
    static int N;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        conveyor = new int[2*N];
        robots = new int[N];
        int count = 0;

        for (int i = 0; i < conveyor.length; i++) {
            conveyor[i] = sc.nextInt();
        }
        
        while (!checkBreakpoint()) {
            rotateConveyor();
            moveRobots();
            raiseRobot();
            count++;
        }

        System.out.println(count);
    }
    static void raiseRobot(){
        if(conveyor[0]!=0){
            robots[0] = 1;
            conveyor[0]--;
        }
    }

    static void moveRobots(){
        for (int i = robots.length-1; i >= 0; i--) {
            // 로봇이 있을 경우
            if(robots[i]==1){
                // 로봇이 밟을 칸이 1 이상일 경우
                if(conveyor[i+1] >= 1 && robots[i+1]!=1){
                    // 로봇을 전진하고 컨베이어 -1
                    robots[i+1] = robots[i];
                    robots[i] = 0;
                    conveyor[i+1]--;
                }
            }
        }

        if(robots[robots.length-1]==1){
            robots[robots.length-1] = 0;
        }
    }

    static void rotateConveyor(){
        int temp = conveyor[conveyor.length-1];
        for (int i = conveyor.length-1; i > 0; i--) {
            conveyor[i] = conveyor[i-1];
        }
        for (int i = robots.length-1; i>=1; i--) {
            robots[i] = robots[i-1];
            robots[i-1] = 0;
        }
        conveyor[0] = temp;
        if(robots[robots.length-1]==1){
            robots[robots.length-1] = 0;
        }
    }

    static boolean checkBreakpoint(){
        int count = 0;
        for (int i = 0; i < conveyor.length; i++) {
            if(conveyor[i] == 0){
                count++;
            }
        }
        if(count >= K) return true;
        else return false;
    }
}
