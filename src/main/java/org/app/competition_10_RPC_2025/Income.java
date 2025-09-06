package org.app.competition_10_RPC_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Income {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] households = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        System.out.println(calculateAverageIncome(n, households));
    }

    static double calculateAverageIncome(int n, long[] households) {
        Arrays.sort(households);
        double totalIncome = Arrays.stream(households).sum();
        double currentIncome = 0;
        double peopleCounted = 1;
        double ans = 0;
        for (int i = n -1; i >= 0; i--) {
            currentIncome += households[i];
            double averageIncome = (currentIncome / totalIncome) * 100;
            double averagePopulation = (peopleCounted / n) * 100;

            ans = Math.max(ans, averageIncome - averagePopulation);
            peopleCounted++;
        }
        return ans;
    }
}
