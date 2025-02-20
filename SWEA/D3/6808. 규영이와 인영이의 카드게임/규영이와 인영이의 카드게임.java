import java.io.*;
import java.util.*;

public class Solution {
	static int[] card;
	static ArrayList<int[]> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] enemy = new int[9];
			card = new int[9];
			set = new ArrayList<>();
			for (int i = 0; i < enemy.length; i++) {
				enemy[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(enemy);

			int count1 = 0;
			int count2 = 0;

			boolean[] v = new boolean[19];
			v[0] = true;
			for (int i = 0; i < enemy.length; i++) {
				v[enemy[i]] = true;
			}

			int index = 0;
			for (int i = 1; i < v.length; i++) {
				if(!v[i]){
					card[index++] = i;
				}
			}

			permu(new int[9], 0, new boolean[9]);

			for (int[] permuset : set) {
				int setcount = 0;
				for (int i = 0; i < 9; i++) {
					if(permuset[i] > enemy[i]){
						setcount += permuset[i] + enemy[i];
					} else{
						setcount -= permuset[i] + enemy[i];
					}
				}
				if(setcount>0) count1++;
				else if(setcount<0) count2++;
			}

			System.out.println("#" + test_case + " " + count2 + " " + count1);
		}
		
	}	
	
	static void permu(int[] sel, int depth, boolean[] visited){
		if(depth==9){
			set.add(Arrays.copyOf(sel, depth));
			return;
		}

		for (int i = 0; i < 9; i++) {
			if(!visited[i]){
				sel[depth] = card[i];
				visited[i] = true;
				permu(sel, depth+1, visited);
				visited[i] = false;
			}
		}
	}

}
