import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static Set<int[]> set;
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
		arr = new int[N][N];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		set = new HashSet<>();

		combN(0, 0, new int[N/2]);
		for(int[] numset : set){
			boolean isContain = false;
			int[] enemy = new int[N/2];
			int count = 0;
			int home = 0;
			int away = 0;
			for (int i = 0; i < N; i++) {
				for (int num : numset) {
					if(i==num){
						isContain = true;
					}
				}
				if (!isContain) {
					enemy[count] = i;
					count++;
				}
				isContain = false;
			}

			for (int i = 0; i < numset.length; i++) {
				for (int j = i; j < numset.length; j++) {
					home += arr[numset[i]][numset[j]] + arr[numset[j]][numset[i]];
					away += arr[enemy[i]][enemy[j]] + arr[enemy[j]][enemy[i]];
				}
			}

			min = Math.min(min, Math.abs(home-away));
			
		}
		System.out.println(min);
	}

	static void combN(int index, int count, int[] sel){
		if(count==N/2){
			set.add(Arrays.copyOf(sel, sel.length));
			return;
		}

		if (index>=N) {
			return;
		}

		sel[count] = index;
		combN(index+1, count+1, sel);
		combN(index+1, count, sel);

	}

}
