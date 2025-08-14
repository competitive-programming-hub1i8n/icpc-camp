package org.app.camp.martes;

import java.util.Scanner;

public class C_AddingReversedNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(solution(sc.nextInt(), sc.nextInt()));
        }
    }

    static int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    static int solution(int a, int b) {
        int reversedA = reverse(a);
        int reversedB = reverse(b);
        return reverse(reversedA + reversedB);
    }
}
