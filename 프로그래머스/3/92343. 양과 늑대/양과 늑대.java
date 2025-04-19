import java.util.*;

class Solution {
    class Node {
        int info;
        List<Integer> edge;

        Node(int info) {
            this.info = info;
            this.edge = new ArrayList<>();
        }
    }

    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        Node[] nodes = new Node[info.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(info[i]);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].edge.add(edge[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(nodes, info, 0, 0, 0, next);
        return answer;
    }

    void dfs(Node[] nodes, int[] info, int current, int sheep, int wolf, List<Integer> next) {
        if (info[current] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return;

        answer = Math.max(answer, sheep);

        List<Integer> newNext = new ArrayList<>(next);
        newNext.remove(Integer.valueOf(current));
        newNext.addAll(nodes[current].edge);

        for (int nextNode : newNext) {
            dfs(nodes, info, nextNode, sheep, wolf, newNext);
        }
    }
}
