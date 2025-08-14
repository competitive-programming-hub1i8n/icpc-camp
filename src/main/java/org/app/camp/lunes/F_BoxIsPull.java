package org.app.camp.lunes;

import java.util.Scanner;

public class F_BoxIsPull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            System.out.println(BoxIsPull(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            n--;
        }
    }
    static int BoxIsPull(int x1, int y1, int x2, int y2) {
        int ans = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        if (x1 == x2 || y1 == y2)
            return ans;
        return ans + 2;
    }
}
