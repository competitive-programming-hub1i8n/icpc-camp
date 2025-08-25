package org.app.ICPC_Brasil_Subregional_2023_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_BestFairShuffles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int[] arr = new int[n];
        String[] arrItems = bufferedReader.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrItems[i]);
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[] arr) {
        int bloques = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                bloques++;
            }
        }

        int k = 0;
        while ((1 << k) < bloques) {
            k++;
        }
        return k;
    }
}
