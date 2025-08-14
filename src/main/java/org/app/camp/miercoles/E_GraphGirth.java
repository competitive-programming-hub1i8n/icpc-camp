package org.app.camp.miercoles;

import java.util.*;

public class E_GraphGirth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] adjMatrix = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true;
        }

        List<List<Integer>> graph = buildGraph(n, adjMatrix);
        solution(n, graph);
    }

    static List<List<Integer>> buildGraph(int n, boolean[][] adjMatrix) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (adjMatrix[i][j])
                    graph.get(i).add(j);

        return graph;
    }

    static void solution(int n, List<List<Integer>> graph) {
        int minCycle = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int cycleLength = bfsCycleLength(start, graph, n);
            if (cycleLength != -1) {
                minCycle = Math.min(minCycle, cycleLength);
            }
        }

        System.out.println(minCycle == Integer.MAX_VALUE ? -1 : minCycle);
    }

    static int bfsCycleLength(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    queue.add(v);
                } else if (parent[u] != v) {
                    return dist[u] + dist[v] + 1;
                }
            }
        }

        return -1;
    }
}
