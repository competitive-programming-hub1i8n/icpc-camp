package org.app.camp.lunes;

import java.util.Scanner;

public class G_UniversityClasses {
    static int[] arr = new int[7];
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            solution(s);
        }
        System.out.println(max);
    }
    static void solution(String university) {
        for (int i = 0; i < university.length(); i++) {
            if (university.charAt(i) == '1') {
                arr[i]++;
                max = Math.max(arr[i], max);
            }
        }
    }
}
