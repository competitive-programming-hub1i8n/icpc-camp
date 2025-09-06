package org.app.competition_10_RPC_2025;

import java.util.Scanner;

public class Labour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(calculateMinimumTimeCoworker(n));
    }

    public static int calculateMinimumTimeCoworker(int t){
        if (t <= 360)
            return 0;
        else if (t <= 540)
            return 30;
        else if (t <= 600)
            return 45;
        else
            return (t - 600) + 45;
    }
}
