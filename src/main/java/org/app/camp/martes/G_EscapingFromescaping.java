package org.app.camp.martes;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G_EscapingFromescaping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            System.out.println(solution(s));
        }
    }
    static int solution(String s) {
        int maxLen = s.length();
        for (int i = 0; i <20 ; i++) {
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < maxLen - i ; j++) {
                set.add(s.substring(j,j+i));
            }
            for (String val : set){
                System.out.println(val);
            }
        }
        return 21;
    }
}
