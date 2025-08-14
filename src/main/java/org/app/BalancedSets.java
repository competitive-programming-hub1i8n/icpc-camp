package org.app;
import java.util.*;

public class BalancedSets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt(); // Número total del conjunto balanceado (impar)
            if (N == -1) break;

            int[] original = new int[N - 1];
            Set<Long> existing = new HashSet<>();
            long sum = 0;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            // Leer los N - 1 números
            for (int i = 0; i < N - 1; i++) {
                original[i] = sc.nextInt();
                sum += original[i];
                existing.add((long) original[i]);
                min = Math.min(min, original[i]);
                max = Math.max(max, original[i]);
            }

            int count = 0;

            // Rango a probar: un margen de ±1000 es suficiente para N pequeño
            for (long x = min - 1000; x <= max + 1000; x++) {
                if (existing.contains(x)) continue;

                long totalSum = sum + x;
                double mean = totalSum / (double) N;

                // Crear nueva lista y ordenarla
                long[] fullSet = new long[N];
                for (int i = 0; i < N - 1; i++) {
                    fullSet[i] = original[i];
                }
                fullSet[N - 1] = x;
                Arrays.sort(fullSet);

                long median = fullSet[(N - 1) / 2];

                if (Math.abs(mean - median) < 1e-9) {
                    count++;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}
