package org.app.competition_10_RPC_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Basketball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] teamOne = Arrays.stream(br.readLine().strip().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] teamTwo = Arrays.stream(br.readLine().strip().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(calculateScore(teamOne, teamTwo));
    }

    static int calculateScore(int[] teamA, int[] teamB) {
        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < teamA.length; i++) {
            if (i == 2){
                scoreA += teamA[i] * 3;
                scoreB += teamB[i] * 3;
            } else if (i == 1) {
                scoreA += teamA[i] * 2;
                scoreB += teamB[i] * 2;
            } else {
                scoreA += teamA[i];
                scoreB += teamB[i];
            }
        }

        if (scoreA > scoreB){
            return 1;
        } else if (scoreB > scoreA) {
            return 2;
        } else {
            return 0;
        }
    }
}
