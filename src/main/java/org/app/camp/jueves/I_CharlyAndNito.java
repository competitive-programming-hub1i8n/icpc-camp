package org.app.camp.jueves;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class I_CharlyAndNito {
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
        long[] dist = new long[n + 1];
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length < 5) continue;
            int J = Integer.parseInt(parts[0]);
            int B = Integer.parseInt(parts[1]);
            int C = Integer.parseInt(parts[2]);
            int N = Integer.parseInt(parts[3]);
            int S = Integer.parseInt(parts[4]);
            if (J == -1 && B == -1 && C == -1 && N == -1 && S == -1) break;

            List<List<Edge>> graph = new ArrayList<>(J + 1);
            for (int i = 0; i <= J; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < S; i++) {
                String[] edgeInfo = br.readLine().trim().split("\\s+");
                int u = Integer.parseInt(edgeInfo[0]);
                int v = Integer.parseInt(edgeInfo[1]);
                int w = Integer.parseInt(edgeInfo[2]);
                graph.get(u).add(new Edge(v, w));
                graph.get(v).add(new Edge(u, w));
            }

            long[] dB = dijkstra(J, graph, B);
            long[] dC = dijkstra(J, graph, C);
            long[] dN = dijkstra(J, graph, N);

            long D_C = dB[C];
            long D_N = dB[N];

            long bestTogether = 0;
            for (int x = 1; x <= J; x++) {
                if (dB[x] + dC[x] == D_C && dB[x] + dN[x] == D_N) {
                    bestTogether = Math.max(bestTogether, dB[x]);
                }
            }
            long C_alone = D_C - bestTogether;
            long N_alone = D_N - bestTogether;
            sb.append(bestTogether).append(" ")
                    .append(C_alone).append(" ")
                    .append(N_alone).append("\n");
        }
        System.out.print(sb.toString());
    }
}
