package org.app.icpc2025.brazil.phase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class J {
    public static void main(String[] args) throws IOException {
        Set<Integer> levels = new java.util.HashSet<>(Set.of(1, 2, 3, 4));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).boxed().toList();
        for (Integer num : nums) {
            if (levels.contains(num)) {
                levels.remove(num);
            }
            if (levels.isEmpty()) {
                System.out.println(levels.size());
                return;
            }
        }
        System.out.println(levels.size());
    }
}
