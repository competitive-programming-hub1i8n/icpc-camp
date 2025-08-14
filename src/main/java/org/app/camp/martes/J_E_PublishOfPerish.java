package org.app.camp.martes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class J_E_PublishOfPerish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            Integer[] m = new Integer[n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
            }
            System.out.println(solution(m));
            n = sc.nextInt();
        }
    }

    static int solution(Integer[] m) {
        int count = 0;
        Arrays.sort(m, Collections.reverseOrder());
        for (int i = 0; i < m.length ; i++) {
            if (m[i] >= i + 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
