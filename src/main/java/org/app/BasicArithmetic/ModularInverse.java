package org.app.BasicArithmetic;

public class ModularInverse {
    public static void main(String[] args) {

    }

    public static int modInverse(int number, int mod){
        // verificamos que sean coprimos
        if (gcd(number,mod) == 1){}
        return number%mod;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
