package org.app.camp.lunes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_LinearKeyboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String keyboard = sc.next();
            String word = sc.next();
            System.out.println(solution(keyboard, word));
        }
    }

    static int solution(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(char c : keyboard.toCharArray()){
            map.put(c, ++index );
        }
        int sum = 0;
        for (int i = 0; i < word.length()-1; i++) {
            System.out.println("Comparing: " + word.charAt(i) + " and " + word.charAt(i + 1) + " with indices: " + map.get(word.charAt(i)) + " and " + map.get(word.charAt(i + 1)));
            sum += Math.abs(map.get(word.charAt(i)) - map.get(word.charAt(i + 1)));
        }
        return sum;
    }
}

