package org.app.camp.miercoles;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class C_Awari2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxes = new int[n];
        if (n > 0){
            for (int i = 0; i < n; i++){
                boxes[i] = sc.nextInt();
            }
            System.out.println(solution(boxes, n)  ? "S" : "N");
            n = sc.nextInt();
        }
    }
    static boolean solution(int[] boxes, int n){
        return false;
    }
}
