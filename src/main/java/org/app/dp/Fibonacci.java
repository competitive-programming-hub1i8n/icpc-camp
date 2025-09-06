package org.app.dp;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 8
        System.out.println(fibonacci(7)); // 13
        System.out.println(fibonacci(8)); // 21
        System.out.println(fibonacci(50)); // 12586269025
    }

    public static int fibonacci(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);

        return apply(n, memo);
    }

    public static int apply(int n, int[] memo){
        if (memo[n] != -1) return memo[n];
        if (n <= 1) return n;
        memo[n] = apply(n-1, memo) + apply(n-2, memo);
        return memo[n];
    }

    public static int fibonacciTab(int n){
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
