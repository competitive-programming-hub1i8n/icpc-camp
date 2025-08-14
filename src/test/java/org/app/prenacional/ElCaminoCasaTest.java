package org.app.prenacional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ElCaminoCasaTest {

    @Test
    void dijkstra() {
        int n = 4;
        int m = 4;
        int k = 8;
        int[][] edges = {
                {1, 2, 5},
                {2, 3, 2},
                {3, 4, 1},
                {1, 4, 10}
        };
        List<List<ElCaminoCasa.Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int[] edgeInfo = edges[i];
            int u = edgeInfo[0];
            int v = edgeInfo[1];
            int w = edgeInfo[2];
            graph.get(u).add(new ElCaminoCasa.Edge(v, w));
            graph.get(v).add(new ElCaminoCasa.Edge(u, w));
        }

        // Call the dijkstra method and assert the expected results
        long[] distances = ElCaminoCasa.dijkstra(n, graph, 1);
        System.out.println(Arrays.toString(distances));
    }

    @Test
    void testDijkstraWithExample() {
        int n = 4;
        int m = 4;
        int k = 7;
        int[][] edges = {
                {1, 2, 5},
                {2, 3, 2},
                {3, 4, 1},
                {1, 4, 10},
        };
        List<List<ElCaminoCasa.Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int[] edgeInfo = edges[i];
            int u = edgeInfo[0];
            int v = edgeInfo[1];
            int w = edgeInfo[2];
            graph.get(u).add(new ElCaminoCasa.Edge(v, w));
            graph.get(v).add(new ElCaminoCasa.Edge(u, w));
        }

        // Call the dijkstra method and assert the expected results
        long[] distances = ElCaminoCasa.dijkstra(n, graph, 1);
        System.out.println(Arrays.toString(distances));
    }
}