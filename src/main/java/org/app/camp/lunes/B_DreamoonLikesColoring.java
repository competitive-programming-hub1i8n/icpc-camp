package org.app.camp.lunes;

import java.util.*;

public class B_DreamoonLikesColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] colors = new Integer[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int color = sc.nextInt();
            colors[i] = color;
            sum += color;
        }
        if (sum > n){
            Arrays.sort(colors, Collections.reverseOrder());
            solution(colors, n, m, sum);
        }else {
            System.out.println(-1);
        }
    }

    static void solution(Integer[] colors, int n, int m, int totalSum) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] rows = new int[n];
        int sum = totalSum;
        int index = 0;
        int li = colors[index];
        if (li > n){
            System.out.println(-1);
            return;
        }
        for (int j = 0; j < li; j++) {
            rows[j] = li;
        }
        sum -= li;
        ans.add(1);
        for (int i = 1; i < n; i++) {
            if (sum >= n - i){
                li = colors[++index];
                if (li > n - i){
                    System.out.println(-1);
                    return;
                }
                for (int j = i; j < i + li; j++) {
                    rows[j] = li;
                }
                sum -= li;
                ans.add(i + 1);
            }
        }
        ans.forEach((x) -> System.out.print(x + " "));
    }
}
