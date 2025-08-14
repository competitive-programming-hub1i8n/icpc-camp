package org.app.camp.martes;

import java.util.Scanner;

public class B_Feynman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            System.out.println(countSquares(n));
            n = sc.nextInt();
        }
    }

    static int countSquares(int n) {
        if (n == 1){
            return 1;
        }
        return countSquares(n-1) + (n * n);
    }
}
