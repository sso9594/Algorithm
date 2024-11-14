import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int min;
	static boolean[] visited;
	static int K;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = Integer.MIN_VALUE;
		visited = new boolean[200001];
		
		// 시작점 N
		// 도착점 K
		// 할 수 있는 행동
		// 1. N+1, 2. N-1, 3. 2*N
		bfs(N);
		System.out.println(min);
		
	}
	
	static void bfs(int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{num, 0});
		visited[num] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int position = current[0];
			int time = current[1];
			
			if(position==K) {
				min = time;
				return;
			}
			
			int[] next = new int[] {position+1, position-1, position*2};
			for(int doNext : next) {
				if(doNext>=0 && !visited[doNext] && doNext <= 100000) {
					visited[doNext] = true;
					queue.offer(new int[] {doNext, time+1});
				}
			}
			
		}
		
	}
}
