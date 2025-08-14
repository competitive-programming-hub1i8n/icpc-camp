package org.app.camp.martes;

import java.util.Scanner;

public class F_ToandFro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            String s = sc.next();
            System.out.println(solution(s, n));
            n = sc.nextInt();
        }
    }
    static String solution(String s, int n) {
        String ans = "";
        int len = s.length();
        int rows = (len + n-1) / n;
        char[][] matrix = new char[rows][n];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            if (!flag) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = s.charAt(index++);
                }
                flag = true;
            }else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[i][j] = s.charAt(index++);
                }
                flag = false;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < rows; i++) {
                ans += matrix[i][j];
            }
        }
        return ans;
    }
}
