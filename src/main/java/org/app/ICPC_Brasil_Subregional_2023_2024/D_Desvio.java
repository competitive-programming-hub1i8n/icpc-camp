package org.app.ICPC_Brasil_Subregional_2023_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_Desvio {

    static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[][] dist = new int[n][n];
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
            adj[i] = new ArrayList<>();
        }

        int[] U = new int[m];
        int[] V = new int[m];
        int[] W = new int[m];


        for (int i = 0; i < m; i++) {
            String[] edgeInfo = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(edgeInfo[0]) - 1;
            int v = Integer.parseInt(edgeInfo[1]) - 1;
            int w = Integer.parseInt(edgeInfo[2]);

            U[i] = u;
            V[i] = v;
            W[i] = w;

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        for (int i = 0; i < m; i++) {
            int u = U[i];
            int v = V[i];
            int w = W[i];
            int[][] newDist = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < n; j++) {
                newDist[j] = Arrays.copyOf(dist[j], dist[j].length);
            }
            newDist[u][v] = INF;
            newDist[v][u] = INF;
            int[][] curr = floydWarshall(newDist, n);

            int desviation = INF;
            for(int[] edge : adj[u]){
                int next = edge[0];
                int weight = edge[1];
                if(next == v && weight == w) continue;
                if(curr[next][v] < INF){
                    desviation = Math.min(desviation, weight + curr[next][v]);
                }
            }
            System.out.println(desviation == INF ? -1 : desviation);
        }
        br.close();

    }

    static int[][] floydWarshall(int[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return  dist;
    }
}
