import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] miro;
	static int[][] distance;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String token = br.readLine();
			for(int j=0; j<M; j++) {
				miro[i][j]= Integer.parseInt(token.charAt(j)+""); 
			}
		}
		
		bfs(0, 0);
		
		System.out.println(distance[N-1][M-1]);
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		distance[x][y] = 1; 
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for(int i=0; i<4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				if(nextX>=0 && nextY>=0 && nextX<N &&
						nextY<M && miro[nextX][nextY]==1
						&& !visited[nextX][nextY]) {
					distance[nextX][nextY] = distance[currentX][currentY] + 1;
					visited[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
		
	}
	
}
