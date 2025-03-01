import java.util.*;

public class Main {
    static int[][] arr;
    static int min;
    static ArrayList<Integer> paperSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[10][10];
        int[] paper = new int[]{5, 5, 5, 5, 5};
        min = Integer.MAX_VALUE;
        paperSet = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    paperSet.add(i * 10 + j);
                }
            }
        }

        dfs(0, paper, new boolean[10][10]);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int index, int[] paper, boolean[][] visited) {
        if (allVisitPaper(visited)) {
            int result = 25;
            for (int i = 0; i < paper.length; i++) {
                result -= paper[i];
            }
            min = Math.min(min, result);
            return;
        }

        if (index >= paperSet.size()) {
            return;
        }

        int current = paperSet.get(index);
        int x = current / 10;
        int y = current % 10;

        if (visited[x][y]) {
            dfs(index + 1, paper, visited);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (isValidSquare(x, y, i + 1, visited) && paper[i] > 0) {
                boolean[][] copyVisited = deepCopy(visited);
                visitSquare(x, y, i + 1, copyVisited);
                paper[i]--;

                dfs(index + 1, paper, copyVisited);

                paper[i]++;
            }
        }
    }

    static boolean allVisitPaper(boolean[][] visited) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void visitSquare(int x, int y, int r, boolean[][] visited) {
        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + r; j++) {
                visited[i][j] = true;
            }
        }
    }

    static boolean isValidSquare(int x, int y, int r, boolean[][] visited) {
        if (x + r > 10 || y + r > 10) {
            return false;
        }
        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + r; j++) {
                if (arr[i][j] != 1 || visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean[][] deepCopy(boolean[][] original) {
        boolean[][] copy = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            copy[i] = Arrays.copyOf(original[i], 10);
        }
        return copy;
    }
}
