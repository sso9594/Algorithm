import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	//상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];
		
		int[] start = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp==2) {
					start[0] = i;
					start[1] = j;
				}
                distance[i][j] = -1;
			}
		}
		
		bfs(start[0], start[1]);
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					distance[i][j] = 0; 
				}
				System.out.print(distance[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		distance[x][y] = 0; 
		int length = 0;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			int currentDis = distance[currentX][currentY];
			
			for(int i=0; i<dx.length; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M && !visited[nextX][nextY]
						&& map[nextX][nextY]==1) {
					queue.offer(new int[] {nextX, nextY});
					distance[nextX][nextY] = currentDis + 1;
					visited[nextX][nextY] = true;
				}
			}
		}
	}
	
}
