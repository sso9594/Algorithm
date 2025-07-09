import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] road = new int[N-1];
        int[] gas = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            gas[i] = Integer.parseInt(st2.nextToken());
        }

        gas[gas.length-1] = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < road.length; i++) {
            answer += gas[i] * road[i];
            int current = i;
            for (int j = i+1; j < road.length; j++) {
                if(gas[i] < gas[j]){
                    answer += gas[i] * road[j];
                    current = j;
                } else {
                    break;
                }
            }
            i = current;
        }

        System.out.println(answer);
    }
}

/**
 * [5, 2, 4]
 * 
 * 현재 위치의 주유소에서 다음 주유소가 자기 보다 낮은 가격일 때 까지의
 * 거리를 전부 구매
 */

 