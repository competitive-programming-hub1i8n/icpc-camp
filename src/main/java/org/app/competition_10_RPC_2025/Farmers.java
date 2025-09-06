package org.app.competition_10_RPC_2025;

import java.util.Scanner;

public class Farmers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int apples = sc.nextInt();
        int bagAmount = sc.nextInt();
        int price = sc.nextInt();
        System.out.println(solution(apples, bagAmount, price));
    }

    static int solution(int apples, int bagAmount, int price){
        int totalApples = apples * bagAmount;
        double dozens = (double) totalApples / 12;
        return (int) (Math.ceil(dozens) * price);

    }
}
