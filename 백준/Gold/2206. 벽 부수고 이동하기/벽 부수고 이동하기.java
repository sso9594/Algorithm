import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int min;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		min = Integer.MAX_VALUE;
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String token = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.charAt(j)+"");
			}
		}

		bfs(0, 0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	// 1 1
	// 0
	// 테케에 대한 처리가 필요

	static void bfs(int x, int y){
		Queue<int[]> queue = new LinkedList<>();
		// 3번째 원소는 벽을 깰 수 있는 기회
		queue.offer(new int[]{x, y, 1, 1});
		visited[x][y][1] = true;
		visited[x][y][0] = true;

		if(x==N-1 && y==M-1){
			min = 1;
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			int breakCount = current[2];
			int distance = current[3];
			for (int i = 0; i < dx.length; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				int nextCount = breakCount;
				int nextDistance = distance+1;
				// 벽 깰 기회가 남아있고, 벽을 만났을 경우
				if(breakCount>0 && nextX>=0 && nextY>=0 && nextX<N && nextY<M && !visited[nextX][nextY][1]
				&& map[nextX][nextY]==1){
					queue.offer(new int[]{nextX, nextY, nextCount-1, nextDistance});
					visited[nextX][nextY][0] = true;
				// 벽 깰 기회가 남아있고, 벽이 없을 경우
				} else if(breakCount > 0 && nextX>=0 && nextY>=0 && nextX<N && nextY<M && !visited[nextX][nextY][1]
				&& map[nextX][nextY]==0){
					queue.offer(new int[]{nextX, nextY, nextCount, nextDistance});
					visited[nextX][nextY][1] = true;
					if(nextX==N-1 && nextY==M-1){
						min = Math.min(min, nextDistance);
					}
				} else if(nextX>=0 && nextY>=0 && nextX<N && nextY<M && !visited[nextX][nextY][0]
				&& map[nextX][nextY]==0){
					queue.offer(new int[]{nextX, nextY, nextCount, nextDistance});
					visited[nextX][nextY][0] = true;
					if(nextX==N-1 && nextY==M-1){
						min = Math.min(min, nextDistance);
					}
				}
			}
		}
	}
}

