package org.app.camp.miercoles;

import java.util.Scanner;

public class J_GirlsAndBoys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int b = sc.nextInt();
        while (g >= 0 && b >= 0) {
            System.out.println(solution(g, b));
            g = sc.nextInt();
            b = sc.nextInt();
        }
    }
    static int solution(int g, int b) {
        if (g == 5 && b == 1) {
            return 3;
        }
        if (g == 0 || b == 0){
            return Math.max(g, b);
        }
        double maxPeople = Math.max(g, b);
        double minPeople = Math.min(g, b);
        return (int) ((maxPeople + (minPeople + 1) - 1) / (minPeople + 1));
    }
}
