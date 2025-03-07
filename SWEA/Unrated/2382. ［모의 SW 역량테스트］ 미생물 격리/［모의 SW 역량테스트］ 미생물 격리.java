import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, K;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Group> groups;
    static class Group implements Comparable<Group>{
        int x, y, num, direction;
        Group(int x, int y, int num, int direction){
            this.x = x;
            this.y = y;
            this.num = num;
            this.direction = direction;
        }
        
        @Override
        public int compareTo(Group o){
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return "[" + x + " " + y + " " + num + " " + direction + "]";
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // map의 크기
            N = Integer.parseInt(st.nextToken());
            // 시간
            M = Integer.parseInt(st.nextToken());
            // 군집의 갯수수
            K = Integer.parseInt(st.nextToken());

            groups = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken())-1;

                Group group = new Group(x, y, num, direction);
                groups.add(group);
            }

            for (int i = 0; i < M; i++) {
                moveGroup();
                checkRedCell();
                mergeGroup();
            }

            int result = 0;
            for (Group group : groups) {
                result += group.num;
            }
            
            System.out.println("#" +  test_case + " " + result);
        }
    }

    static void mergeGroup(){
        Map<List<Integer>, List<Group>> map = new HashMap<>();
        for (Group target : groups) {
            if(map.getOrDefault(Arrays.asList(target.x, target.y), null)!=null){
                List<Group> temp = map.get(Arrays.asList(target.x, target.y));
                temp.add(target);
                map.put(Arrays.asList(target.x, target.y), temp);
            } else if(map.getOrDefault(Arrays.asList(target.x, target.y), null)==null){
                List<Group> temp = new ArrayList<>();
                temp.add(target);
                map.put(Arrays.asList(target.x, target.y), temp);
            }
        }

        for (Map.Entry<List<Integer>, List<Group>> target : map.entrySet()) {
            if(target.getValue().size()>1){
                List<Group> mergeGroups = target.getValue();
                Group max = mergeGroups.get(0);
                for (Group group : mergeGroups) {
                    if(group.compareTo(max)>0){
                        max = group;
                    }
                }
                groups.removeAll(mergeGroups);
                mergeGroups.remove(max);
                for (Group group : mergeGroups) {
                    max.num += group.num;
                }
                groups.add(max);
            }
        }
    }

    static void checkRedCell(){
        for (int i = 0; i < groups.size(); i++) {
            Group target = groups.get(0);
            groups.remove(target);
            if((target.x == 0 || target.x == N-1)
            || (target.y == 0 || target.y == N-1)){
                target.num /= 2;
                target.direction = (target.direction%2==0)
                ? target.direction+1 : target.direction-1;
            }
            groups.add(target);
        }
    }

    static void moveGroup(){
        for (int i = 0; i < groups.size(); i++) {
            Group target = groups.get(0);
            groups.remove(target);
            target.x += dx[target.direction];
            target.y += dy[target.direction];   
            groups.add(target);
        }
    }
}
