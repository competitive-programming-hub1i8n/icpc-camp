package org.app.competition_10_RPC_2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Around {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(countPairs(l,r));
    }

    static long countPairs(long l, long r) {
        long count = 0;
        long n  = l + r;
        long[] players = new long[(int) n];
        for (int i = 0; i < n; i++) {
            players[i] = i;
        }

        long pairCount = n / gcd(n, l);
        System.out.println(pairCount);
        return count;
    }

    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
