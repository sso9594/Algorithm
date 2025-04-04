import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int count;
	static int[][] compare;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            
            count = 0;

            compare = new int[N][N];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                compare[v][e] = 1;
            }

            for (int i = 0; i < N; i++) {
                bfs(i);
            }

            System.out.println("#" + test_case + " " + count);
        }
		
	}

	static void bfs(int v){
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(v);
		boolean[] visited = new boolean[N];
		visited[v] = true;
		while (!queue.isEmpty()) {
			int currentV = queue.poll();
			for (int i = 0; i < N; i++) {
				if(compare[currentV][i]==1 && !visited[i]){
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

		queue.offer(v);

		while (!queue.isEmpty()) {
			int currentV = queue.poll();
			for (int i = 0; i < N; i++) {
				if(compare[i][currentV]==1 && !visited[i]){
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

		boolean valid = true;
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]){
				valid = false;
			}
		}

		if(valid) count++;
	}
}