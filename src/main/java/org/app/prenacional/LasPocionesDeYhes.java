package org.app.prenacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class LasPocionesDeYhes {
    record Pair(int key, Set<Integer> value) {}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().strip().split("\\s+");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        List<Pair> potions = new ArrayList<>();
        IntStream.range(0, m).forEach(i -> {
            try {
                String[] mLines = br.readLine().strip().split("\\s+");
                int k = Integer.parseInt(mLines[0]);
                Set<Integer> ingredients = new HashSet<>();
                for (int j = 1; j <= k; j++) {
                    ingredients.add(Integer.parseInt(mLines[j]));
                }
                Pair p = new Pair(k, ingredients);
                potions.add(p);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(solution(n, m, potions));

    }

    public static int solution(int n, int m, List<Pair> potions) {
        int allSets = (int) Math.pow(2, n);
        int eiSubsets = 0;
        int intersections = 0;
        int index = 1;
        for(Pair p : potions){
            int k = p.key;
            Set<Integer> ingredients = p.value;
            eiSubsets += (int) Math.pow(2, n - k);
            for (int j = index; j < m; j++) {
                Set<Integer> otherIngredients = potions.get(j).value;
                Set<Integer> intersection = new HashSet<>(ingredients);
                intersection.addAll(otherIngredients);
                int intersectionSize = intersection.size();
                intersections += (int) Math.pow(2, n - intersectionSize);
            }
            index++;
        }
        if (m > 2){
            return allSets - ((eiSubsets - intersections) + 1);
        }
        return allSets - (eiSubsets - intersections);
    }
}