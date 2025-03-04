import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args){
		//--------------솔루션 코드를 작성하세요.--------------------------------
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int level = 0; level < Integer.MAX_VALUE; level++) {
			int area = 0;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]>level) {
						bfs(i,j,level,visited);
						area++;
					}
				}
			}
			if(area == 0) {
				break;
			}
			
			result = Math.max(result, area);
		}
		
		System.out.println(result);
	}
	
	static void bfs(int x, int y, int level, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<N
						&& !visited[nextX][nextY] && map[nextX][nextY]>level) {
					queue.offer(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}

	}

}
