package org.app.icpc2025.brazil.phase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] maxValues = new int[m];
        for (int i = 0; i < n; i++) {
            String[] values = bufferedReader.readLine().trim().split("\\s+");
            int p1 = 0;
            int p2 = m - 1;
            while (p1 <= p2) {
                int val1 = Integer.parseInt(values[p1]);
                int val2 = Integer.parseInt(values[p2]);
                maxValues[p1] = Math.max(maxValues[p1], val1);
                maxValues[p2] = Math.max(maxValues[p2], val2);
                p1++;
                p2--;
            }
        }
        int sum = Arrays.stream(maxValues).sum();
        System.out.println(sum);
    }
}
