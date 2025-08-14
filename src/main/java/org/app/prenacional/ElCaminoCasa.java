package org.app.prenacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ElCaminoCasa {
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static long[] dijkstra(int n, List<List<Edge>> graph, int src) {
        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[src] = 0;
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            long d = cur[1];
            if (d != dist[u]) continue;
            for (Edge e : graph.get(u)) {
                int v = e.to;
                long nd = d + e.weight;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new int[]{v, (int) nd});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().trim().split("\\s+");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int K = Integer.parseInt(parts[2]);

        List<List<Edge>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            String[] edgeInfo = bufferedReader.readLine().trim().split("\\s+");
            int u = Integer.parseInt(edgeInfo[0]) - 1;
            int v = Integer.parseInt(edgeInfo[1]) - 1;
            int w = Integer.parseInt(edgeInfo[2]);
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        long[] dist = dijkstra(N, graph, 0);
        System.out.println(Arrays.toString(dist));
        if (dist[N - 1] <= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        bufferedReader.close();
    }
}
/*
4 4 7
1 2 5
2 3 2
3 4 1
1 4 10
 */