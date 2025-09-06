package org.app.competition_10_RPC_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Injured {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        Set<String> dictionary = new TreeSet<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                dictionary.add(br.readLine().trim());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        int m = Integer.parseInt(br.readLine().trim());
        IntStream.range(0, m).forEach(i -> {
            try {
                String injuredWord = br.readLine().trim();
                System.out.println(findClosestWord(injuredWord, dictionary));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static int findClosestWord(String injuredWord, Set<String> dictionary) {
        if (dictionary.contains(injuredWord)) {
            return 1;
        } else if (isConcat(injuredWord, dictionary)) {
            return 2;
        }
        return 0;
    }

    static boolean isConcat(String injuredWord, Set<String> dictionary) {
        for (String word : dictionary) {
            if (injuredWord.startsWith(word)) {
                String suffix = injuredWord.substring(word.length());
                if (dictionary.contains(suffix)) {
                    return true;
                }
            }
        }
        return false;
    }
}
