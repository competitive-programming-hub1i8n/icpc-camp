package org.app.camp.viernes;

import java.util.Scanner;

public class C_Chocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] chocolates = new int[n];
        for (int i = 0; i < n; i++) {
            chocolates[i] = sc.nextInt();
        }
        System.out.println(solution(chocolates));
    }

    static int solution(int[] chocolates) {
        int lim = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = chocolates.length - 1; i >= 0; i--) {
            lim = Math.min(chocolates[i], Math.max(lim - 1, 0));
            ans += lim;
        }
        return ans;
    }
}
