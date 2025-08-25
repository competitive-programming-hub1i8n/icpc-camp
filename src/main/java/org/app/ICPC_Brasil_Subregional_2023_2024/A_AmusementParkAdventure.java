package org.app.ICPC_Brasil_Subregional_2023_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_AmusementParkAdventure {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        int count = 0;
        String[] heightInfo = bufferedReader.readLine().trim().split("\\s+");

        for (int i = 0; i < n; i++) {
            int minHeight = Integer.parseInt(heightInfo[i]);
            if (isPossible(minHeight, h))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isPossible(int minHeight, int h) {
        return h >= minHeight;
    }
}
