package org.app.camp.miercoles;

import java.util.Scanner;

public class D_PhoneCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] phones = new String[n];
        for (int i = 0; i < n; i++) {
            String phoneNumber = sc.next();
            phones[i] = phoneNumber;
        }
        System.out.println(formatPhoneNumber(phones, n));
    }
    static int formatPhoneNumber(String[] phoneNumber, int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phoneNumber[0].length(); i++) {
            char current = phoneNumber[0].charAt(i);
            for (int j = 1; j < n; j++) {
                char next = phoneNumber[j].charAt(i);
                if (current != next) {
                    return count;
                }
            }
            sb.append(current);
            count++;
        }
        System.out.println(sb.toString());
        return count;
    }
}
