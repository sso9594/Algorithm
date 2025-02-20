import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;

	// 상 좌 우
	static int[] dx = {-1,0,0};
	static int[] dy = {0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// int T = Integer.parseInt(br.readLine());
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {		
			int t = Integer.parseInt(br.readLine());
			map = new int[100][100];
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==2){
						startX = i;
						startY = j;
					}
				}
			}

			System.out.println("#" + test_case + " " + bfs(startX, startY));
		}
		
	}

	static int bfs(int x, int y){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		boolean[][] visited = new boolean[100][100];
		visited[x][y] = true;
		// 무조건 좌우이동이 가능한 경우 좌우만 넣고 continue;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			if(currentX == 0){
				return currentY;
			}
			for (int i = dx.length-1; i >= 0; i--) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				// 좌우 이동이 가능한 경우
				if(nextX>=0 && nextY>=0 && nextX<100 && nextY<100 && map[nextX][nextY]==1
				&& (i==1 || i==2) && !visited[nextX][nextY]){
					visited[nextX][nextY] = true;
					queue.offer(new int[]{nextX, nextY});
					break;
				} else if(nextX>=0 && nextY>=0 && nextX<100 && nextY<100 && map[nextX][nextY]==1
				&& !visited[nextX][nextY]){
					visited[nextX][nextY] = true;
					queue.offer(new int[]{nextX, nextY});
					break;
				}
			}
		}

		return 0;
	}

}
