package org.app.ICPC_Brasil_Subregional_2023_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C_ChallengingHike {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] paths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] likes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = solution(n, paths, likes);
        for (int val : result) {
            System.out.print(val + " ");
        }
        br.close();
    }

    public static int[] solution(int n, int[] paths, int[] likes){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int u = i;
            int v = paths[i - 2];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Node> dfsResult = dfs(adj, n, likes);
        dfsResult.removeFirst();
        int[] ans = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ans[i] = dfsResult.get(i).lis;
        }
        return ans;
    }

    public static List<Node> dfs(ArrayList<ArrayList<Integer>> adj, int n, int[] likes) {
        boolean[] visited = new boolean[n + 1];
        List<Node> result = new ArrayList<>();
        dfsUtil(adj, visited, 1, result, likes, new ArrayList<>());
        return result;
    }

    private static void dfsUtil(ArrayList<ArrayList<Integer> > adj,boolean[] visited, int s, List<Node> res, int[] likes, List<Integer> path)
    {
        visited[s] = true;
        path.add(likes[s - 1]);

        int lis = lis(path.stream().mapToInt(Integer::intValue).toArray());
        res.add(new Node(s, likes[s-1], lis));
        for ( Integer node: adj.get(s)) {
            if (!visited[node]) {
                dfsUtil(adj, visited, node, res, likes, path);
            }
        }
        path.removeLast();
    }

    public record Node(int index, int value, int lis) {}

    static int lis(int[] arr) {
        List<Integer> sub = new ArrayList<>();

        for (int num : arr) {
            int pos = Collections.binarySearch(sub, num);

            if (pos < 0) {
                pos = -(pos + 1); // posición donde debería insertarse
            }

            if (pos == sub.size()) {
                sub.add(num); // si num es mayor que todo, se agrega
            } else {
                sub.set(pos, num); // si no, reemplaza el valor más grande posible
            }
        }

        return sub.size();
    }
}
