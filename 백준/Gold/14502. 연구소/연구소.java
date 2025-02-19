import java.io.*;
import java.util.*;
import java.util.concurrent.Future;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<int[][]> set;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		set = new ArrayList<>();
		int max = 0;
		ArrayList<int[]> virusSet = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cell = Integer.parseInt(st.nextToken());
				map[i][j] = cell;
				if(cell==2){
					virusSet.add(new int[]{i, j});
				}
			}
		}

		// 벽을 세운다
		combMat(N, M, 0, 0, new boolean[N][M], new int[3][2]);
		// 바이러스 칸을 시작으로 bfs로 탐색한다
		for (int[][] wallSet : set) {
			int count = 0;
			// 맵 복사
			int[][] cpyMap = new int[N][M];
			for (int i = 0; i < cpyMap.length; i++) {
				cpyMap[i] = map[i].clone();
			}
			for (int[] wall : wallSet) {
				cpyMap[wall[0]][wall[1]] = 1;
			}
			for (int[] virus : virusSet) {
				bfs(virus[0], virus[1], cpyMap);
			}
			// 0인 칸 수를 센다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(cpyMap[i][j]==0){
						count++;
					}
				}
			}

			max = Math.max(max, count);
		}
		System.out.println(max);
	}

	// 방문하는 노드 전부 2로 만드는 bfs
	static void bfs(int x, int y, int[][] map){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			for (int i = 0; i < dx.length; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && map[nextX][nextY]==0){
					map[nextX][nextY] = 2;
					queue.offer(new int[]{nextX, nextY});
				}
			}
		}
	}

	static void combMat(int x, int y, int index, int depth, boolean[][] visited, int[][] sel){
		if(depth==3){
			int[][] cpy = new int[3][2];
			for (int i = 0; i < cpy.length; i++) {
				cpy[i] = sel[i].clone();
			}
			set.add(cpy);
			return;
		}

		for (int i = index; i < x*y; i++) {
			int currentX = i/y;
			int currentY = i%y;
			if(!visited[currentX][currentY] && map[currentX][currentY]==0){
				visited[currentX][currentY] = true;
				sel[depth][0] = currentX;
				sel[depth][1] = currentY;
				combMat(x, y, i+1, depth+1, visited, sel);
				visited[currentX][currentY] = false;
			}
		}
		
	}
}

// 0은 빈 칸, 1은 벽, 2는 바이러스
// 벽 3개를 세워 최소 바이러스를 구하기기