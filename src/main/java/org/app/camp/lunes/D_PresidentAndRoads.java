package org.app.camp.lunes;

import java.util.*;

public class D_PresidentAndRoads {
    static class Edge {
        int from, to, weight;
        public Edge(int f, int t, int w) {
            from = f; to = t; weight = w;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        long dist;
        public Node(int id, long dist) {
            this.id = id;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static int n, m, s, t;
    static List<List<int[]>> graph = new ArrayList<>();
    static List<List<int[]>> revGraph = new ArrayList<>();
    static List<Edge> edges = new ArrayList<>();

    static long[] dijkstra(int start, List<List<int[]>> g) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.dist > dist[current.id]) continue;
            for (int[] neighbor : g.get(current.id)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                if (dist[next] > dist[current.id] + weight) {
                    dist[next] = dist[current.id] + weight;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph.get(u).add(new int[]{v, w});
            revGraph.get(v).add(new int[]{u, w});
            edges.add(new Edge(u, v, w));
        }

        long[] distFromS = dijkstra(s, graph);
        long[] distToT = dijkstra(t, revGraph);

        long shortest = distFromS[t];

        for (Edge e : edges) {
            int u = e.from, v = e.to, w = e.weight;
            long throughEdge = distFromS[u] + w + distToT[v];

            if (throughEdge == shortest) {
                System.out.println("YES");
            } else {
                long maxAllowedWeight = shortest - distFromS[u] - distToT[v] - 1;
                if (maxAllowedWeight >= 1 && maxAllowedWeight < w) {
                    System.out.println("CAN " + maxAllowedWeight);
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
