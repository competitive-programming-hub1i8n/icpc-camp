package org.app.camp.lunes;

import java.util.Scanner;

public class C_Elephant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int cont = 0;
        while (n != 0) {
            if (n >= 5){
                n -= 5;
                cont++;
            } else if (n >= 4) {
                n-= 4;
                cont++;
            }
            else if (n >= 3) {
                n-= 3;
                cont++;
            }
            else if (n >= 2) {
                n-= 2;
                cont++;
            }
            else if (n >= 1) {
                n-= 1;
                cont++;
            }
        }
        return cont;
    }
}
