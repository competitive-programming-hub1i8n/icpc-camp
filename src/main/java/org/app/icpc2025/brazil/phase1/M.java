package org.app.icpc2025.brazil.phase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class M {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        List<Integer> segmentsHeights = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).boxed().toList();
        System.out.println(solution(n, m, segmentsHeights));
    }

    public static int solution(int n, int m, List<Integer> segmentsHeights) {

        return 0;
    }
}
