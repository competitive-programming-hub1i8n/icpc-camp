package org.app;

public class EvenOddValidator {
    public boolean isEvenOrOdd(int number) {
        return (number & 1) == 0;
    }
}
