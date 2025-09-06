package org.app.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Collatz {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.trim().split("\\s+");
                int i = Integer.parseInt(split[0]);
                int j = Integer.parseInt(split[1]);
                apply(i, j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void apply(int i, int j){
        int max = 0;
        for (int j1 = i; j1 <= j; j1++){
            max = Math.max(max, collatzCycleLength(j1, new int[j+1]));
        }
        System.out.println(i + " " + j + " " + max);
    }

    public static int collatzCycleLength(int i, int[] memo){
        if (i == 1) return 1;
        if (i < memo.length && memo[i] != 0) return memo[i];
        int length;
        if (i % 2 == 0) {
            length = 1 + collatzCycleLength(i / 2, memo);
        } else {
            length = 1 + collatzCycleLength(3 * i + 1, memo);
        }
        if (i < memo.length) {
            memo[i] = length;
        }
        return length;
    }

}
