package org.app.camp.lunes;

/*import java.util.*;

public class E_TheTwoRoutes {
    static int minStep = Integer.MAX_VALUE;
    static int minStepAux = minStep;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] listAd = new int[n][n];
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            listAd[u][v] = 1;
            listAd[v][u] = 1;
        }
        System.out.println(solution(listAd, visited, 0, 0));
    }

    public static int solution(int[][] listAd, Boolean[] visited, int row, int step) {
        if (row == listAd.length-1) {
            minStep = Math.min(step, minStep);
            return minStep;
        }else {
            visited[0] = true;
            for (int i = 0; i < listAd.length; i++) {
                if (listAd[row][i] == 0 && !visited[i]) {
                    visited[i] = true;
                    step += 1;
                    return solution(listAd, visited, i, step);
                }
            }
        }
        return minStepAux == minStep ? -1 : minStep;
    }

}
*/

import java.util.*;

public class E_TheTwoRoutes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] rail = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            rail[u][v] = true;
            rail[v][u] = true;
        }
        System.out.println(Arrays.deepToString(rail));
        List<List<Integer>> railGraph = buildGraph(n, rail);
        System.out.println(railGraph);
        List<List<Integer>> roadGraph = buildGraph(n, complement(rail, n));
        System.out.println(roadGraph);

        int trainTime = bfs(railGraph, 0, n - 1, n);//3
        int busTime = bfs(roadGraph, 0, n - 1, n);//2
        System.out.println("Training time: " + trainTime);
        System.out.println("Bus time: " + busTime);

        if (trainTime == -1 || busTime == -1) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(trainTime, busTime));
        }
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

    static boolean[][] complement(boolean[][] matrix, int n) {
        boolean[][] comp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && !matrix[i][j])
                    comp[i][j] = true;

        System.out.println(Arrays.deepToString(comp));
        return comp;
    }

    static int bfs(List<List<Integer>> graph, int start, int end, int n) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist[end];
    }
}
