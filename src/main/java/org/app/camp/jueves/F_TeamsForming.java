package org.app.camp.jueves;

import java.util.Arrays;
import java.util.Scanner;

public class F_TeamsForming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] skills = new int[n];
        int maxSkill = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            maxSkill = Math.max(maxSkill, skills[i]);
            skills[i] = x;
        }
        System.out.println(solution(skills, maxSkill, n));
    }

    static int solution(int[] skills, int maxSkill, int n) {
        int ans = 0;
        Arrays.sort(skills);
        for (int i = 0; i < n -1; i+=2) {
            while (skills[i] != skills[i+1]) {
                skills[i]++;
                ans++;
            }
        }
        return ans;
    }
}
