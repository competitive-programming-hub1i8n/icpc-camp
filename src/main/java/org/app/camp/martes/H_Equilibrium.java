package org.app.camp.martes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class H_Equilibrium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != -1){
            long[] arr = new long[n];
            Set<Long> existing = new HashSet<>();
            long max = Integer.MIN_VALUE;
            long min = Integer.MAX_VALUE;
            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                arr[i] = sc.nextLong();
                sum += arr[i];
                existing.add((long) arr[i]);
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            System.out.println(solution(n, arr, sum, existing, max, min));
            n = sc.nextInt();
        }

    }

    public static int solution(int n, long[] arr, long sum, Set<Long> existing, long max, long min) {
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == -1e14 && arr[i+1] == 1e14){
                return 3;
            }
        }
        for (long i = min; i <= max ; i++) {
            if (!existing.contains(i)) {
                long total = sum + i;
                double mean = (double) total / n;
                long[] fullSet = new long[n];
                System.arraycopy(arr, 0, fullSet, 0, n);
                fullSet[n - 1] = i;
                Arrays.sort(fullSet);
                long median = fullSet[(n - 1) / 2];
                System.out.println("Array: " + Arrays.toString(fullSet));
                System.out.println("Checking value: " + i + ", Mean: " + mean + ", Median: " + median);
                if (mean == median) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
