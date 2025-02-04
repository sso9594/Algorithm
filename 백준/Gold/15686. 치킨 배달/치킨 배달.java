import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<int[]> set;
	static int min;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][N];
		min = Integer.MAX_VALUE;
		set = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2){
					set.add(new int[]{i, j});
				}
			}
		}
		
		// 치킨집의 좌표 2개를 M개 저장할 배열 초기화화
		comb(0, 0, new int[M][2]);

		System.out.println(min);
	}

	static void comb(int depth, int index, int[][] sel){
		if(depth == M){
			// 거리 최소값 구하는 로직
			int mapSum = 0; // 도시의 치킨거리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 1일 경우 해당 i,j 좌표에서 sel과의 거리 최소값을 더해 저장
					if(arr[i][j]==1){
						int disMin = Integer.MAX_VALUE;
						for (int[] chicken : sel) {
							int sum = 0;
							sum += Math.abs(chicken[0]-i);
							sum += Math.abs(chicken[1]-j);
							disMin = Math.min(sum, disMin);
						}
						mapSum += disMin;
					}
				}
			}

			min = Math.min(min, mapSum);
			return;
		}

		if (index >= set.size()) {
			return;
		}

		// 조합을 구하는 로직
		sel[depth] = set.get(index);
		comb(depth+1, index+1, sel);
		comb(depth, index+1, sel);
	}
}