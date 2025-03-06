import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static Map<Integer, Character> command;
    // 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        L = Integer.parseInt(br.readLine());
        command = new HashMap<>();
        
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command.put(Integer.valueOf(st.nextToken()), st.nextToken().charAt(0));
        }

        System.out.println(game());
    }

    static int game() {
        Deque<int[]> queue = new ArrayDeque<>();
        Set<List<Integer>> snake = new HashSet<>();
        queue.add(new int[]{1,1});
        snake.add(Arrays.asList(1, 1));
        int time = 0;
        int direction = 0;
        int x=1, y=1;
        while (true) {
            time++;
            x += dx[direction];
            y += dy[direction];
            
            if (x < 1 || x > N || y < 1 || y > N || snake.contains(Arrays.asList(x, y))) {
                break;
            }
            
            queue.add(new int[]{x, y});
            snake.add(Arrays.asList(x, y));
            
            if (map[x][y]) {
                map[x][y] = false;
            } else {
                int[] tail = queue.pollFirst();
                snake.remove(Arrays.asList(tail[0], tail[1]));
            }
            
            if (command.containsKey(time)) {
                char turn = command.get(time);
                direction = changeDirection(turn, direction);
            }
        }

        return time;
    }

    static int changeDirection(char turn, int direction){
        if(turn == 'L') return (direction+3)%4;
        else return (direction+1)%4;
    }
}
