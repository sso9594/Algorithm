import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
	static Set<int[]> set;
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][9];
		int max = 0;

		set = new HashSet<>();
		permu(new int[8], 0, 0, new boolean[9]);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int[] numSet : set) {
			ArrayList<Integer> current = new ArrayList<>();
			for (int num : numSet) {
				current.add(num);
			}
			current.add(3, 0);
			int score = 0;
			int j=0;
			for (int i = 0; i < N; i++) {
				int outCount = 3;
				int inningScore = 0;
				int[] ground = new int[4];
				while (outCount > 0) {
					int currentNum = arr[i][current.get(j)];
					// currentNum이 몇루타인지이고, 이 값을 받아서 이 타석으로 몇점을 획득했는지 반환하는 함수
					if(currentNum==0){
						outCount--;
						j = (j+1)%9;
						continue;
					}					
					inningScore += run(ground, currentNum);
					j = (j+1)%9;
				}
				score += inningScore;
			}

			max = Math.max(score, max);
			
		}
		
		
		System.out.println(max);
	}

	static void permu(int[] sel, int index, int depth, boolean[] visited){
		if (depth == 8) {
			set.add(Arrays.copyOf(sel, depth));
			return;
		}

		for (int i = 1; i < 9; i++) {
			if(!visited[i]){
				sel[index] = i;
				visited[i] = true;
				permu(sel, index+1, depth+1, visited);
				visited[i] = false;
			}

		}
	}

	static int run(int[] ground, int currentNum){
		// ground의 인덱스는 몇루인지를 나타냄
		int score = 0;
		for (int i = ground.length-1; i >= 0; i--) {
			if(ground[i]==1){
				int locate = i+currentNum;
				if(locate>=4){
					score++;
				} else {
					ground[locate] = 1;
				}
				ground[i] = 0;
			}
		}

		// 해당 타석 주자 처리
		if (currentNum==4) {
			score++;
		} else if(currentNum<4){
			ground[currentNum] = 1;
		}
		return score;
	}
}