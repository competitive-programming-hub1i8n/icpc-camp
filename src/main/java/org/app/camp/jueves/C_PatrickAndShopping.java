 package org.app.camp.jueves;

import java.util.Scanner;

public class C_PatrickAndShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int d3 = sc.nextInt();
        System.out.println(solution(d1, d2, d3));
    }

    static int solution(int d1, int d2, int d3) {
        int min = Math.min(d1, d2);
        int max = Math.max(d1, d2);

        int total = min;

        if (d3 < d1 + d2)
            total += d3;
        else
            total += (d1+d2);

        if (max < d3 + min)
            return total + max;
        return total + (d3 + min);
    }
}
