import java.awt.Image;
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] box;
	static int[][] day;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//1은 익은 토마토 0은 익지 않은 토마토, -1은 토마토 없음
		//익은 토마토의 상하좌우 토마토가 익음
		box = new int[N][M];
		day = new int[N][M];
		queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] =  Integer.parseInt(st.nextToken());
				if(box[i][j]==1) {
					queue.offer(new int[] {i, j});
				} else if(box[i][j]==0) {
					day[i][j] = -1; 
				}
			}
		}
		
		bfs();
		int result = 0;
		
		for(int i=0; i<N; i++) {
			boolean valid = true;
			for(int j=0; j<M; j++) {
				if (day[i][j]==-1) {
					result = -1;
					valid = false;
					break;
				}
				result = Math.max(result, day[i][j]);
			}
			if(!valid) break;
		}
		
		System.out.println(result);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for(int i=0; i<4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M &&
						box[nextX][nextY]==0 && day[nextX][nextY] < 1) {
					day[nextX][nextY] = day[currentX][currentY] + 1;
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
		
	}
	
}
