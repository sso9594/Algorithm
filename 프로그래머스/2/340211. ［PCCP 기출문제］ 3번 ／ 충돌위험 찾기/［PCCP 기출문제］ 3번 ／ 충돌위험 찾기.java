import java.util.*;

class Solution {

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int x = routes.length;

        Point[] pointList = new Point[n + 1];
        for (int i = 0; i < n; i++) {
            pointList[i + 1] = new Point(points[i][0], points[i][1]);
        }

        List<List<Point>> robotPaths = new ArrayList<>();
        int maxTime = 0;

        for (int[] route : routes) {
            List<Point> path = new ArrayList<>();

            for (int i = 0; i < route.length - 1; i++) {
                int from = route[i];
                int to = route[i + 1];

                Point start = pointList[from];
                Point end = pointList[to];

                if (i == 0) path.add(new Point(start.x, start.y));

                int r = start.x, c = start.y;
                while (r != end.x) {
                    r += (end.x > r ? 1 : -1);
                    path.add(new Point(r, c));
                }

                while (c != end.y) {
                    c += (end.y > c ? 1 : -1);
                    path.add(new Point(r, c));
                }
            }

            robotPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        int answer = 0;

        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> countMap = new HashMap<>();

            for (List<Point> path : robotPaths) {
                if (t < path.size()) {
                    Point p = path.get(t);
                    String key = p.x + "," + p.y;
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }
            }

            for (int count : countMap.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
