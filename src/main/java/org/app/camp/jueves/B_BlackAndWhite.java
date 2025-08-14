package org.app.camp.jueves;

import java.util.Scanner;

public class B_BlackAndWhite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();
        while (!s.equals("*") && !t.equals("*")) {
            System.out.println(solution(s, t));
            s = sc.next();
            t = sc.next();
        }
    }

    static int solution(String s, String t) {
        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)){
                flag = true;
            }
            else if (flag){
                ans++;
                flag = false;
            }
            if (flag && i == s.length() - 1) {
                ans++;
            }
        }
        return ans;
    }
}

/*// Java program to find N-th term in
// George Cantor set of rational number
import java.io.*;

class GFG
{


    // Driver code
    public static void main (String[] args)
    {
        int n = 15;
        georgeCantor(n);

    }
}

// This code is contributed by vt_m*/
