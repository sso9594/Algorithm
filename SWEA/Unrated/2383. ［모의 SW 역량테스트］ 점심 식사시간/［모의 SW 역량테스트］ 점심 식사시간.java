import java.util.*;

class Solution {
    static int minTime;
    static class Person {
        int r, c, stairIdx, dist;
        Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Stair {
        int r, c, length;
        Stair(int r, int c, int length) {
            this.r = r;
            this.c = c;
            this.length = length;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            List<Person> people = new ArrayList<>();
            Stair[] stairs = new Stair[2];
            int stairIdx = 0;
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 1) {
                        people.add(new Person(r, c));
                    } else if (map[r][c] >= 2) {
                        stairs[stairIdx++] = new Stair(r, c, map[r][c]);
                    }
                }
            }
            
            minTime = Integer.MAX_VALUE;
            permu(people, stairs, 0);
            System.out.println("#" + t + " " + minTime);
        }
    }

    static int calculateDistance(Person p, Stair s) {
        return Math.abs(p.r - s.r) + Math.abs(p.c - s.c);
    }
    
    static int process(List<Integer> arrivals, int stairLength) {
        Queue<Integer> stairQueue = new LinkedList<>();
        int time = 0, index = 0;
        
        while (index < arrivals.size() || !stairQueue.isEmpty()) {
            time++;
            while (!stairQueue.isEmpty() && stairQueue.peek() + stairLength <= time) {
                stairQueue.poll();
            }
            while (stairQueue.size() < 3 && index < arrivals.size() && arrivals.get(index) + 1 <= time) {
                stairQueue.offer(time);
                index++;
            }
        }
        
        return time;
    }

    static int simulate(List<Person> people, Stair[] stairs) {
        List<Integer>[] arrivalTimes = new ArrayList[2];
        arrivalTimes[0] = new ArrayList<>();
        arrivalTimes[1] = new ArrayList<>();
        
        for (Person p : people) {
            p.dist = calculateDistance(p, stairs[p.stairIdx]);
            arrivalTimes[p.stairIdx].add(p.dist);
        }
        
        arrivalTimes[0].sort(Integer::compareTo);
        arrivalTimes[1].sort(Integer::compareTo);
        
        return Math.max(process(arrivalTimes[0], stairs[0].length), 
            process(arrivalTimes[1], stairs[1].length));
    }
        
    static void permu(List<Person> people, Stair[] stairs, int idx) {
        if (idx == people.size()) {
            minTime = Math.min(minTime, simulate(people, stairs));
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            people.get(idx).stairIdx = i;
            permu(people, stairs, idx + 1);
        }
    }
    
}
