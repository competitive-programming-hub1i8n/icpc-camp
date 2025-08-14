package org.app.camp.jueves;

import java.util.Scanner;

public class H_CountOnCantor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int term = sc.nextInt();
            georgeCantor(term);
        }

    }
    static void georgeCantor(int n)
    {
        int i = 1;
        int j = 1;
        int k = 1;
        while (k < n)
        {
            j++ ;
            k++;
            if (k == n)
                break;
            while (j > 1 && k < n) {
                i++;
                j--;
                k++;
            }
            if (k == n)
                break;
            i++;
            k++;
            if (k == n)
                break;
            while (i > 1 && k < n) {
                i--;
                j++;
                k++;
            }
        }

        System.out.println("TERM " + n + " IS " + i +"/" +j);
    }
}
