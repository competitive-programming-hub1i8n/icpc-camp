package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenOddValidatorTest {

   @Test
    void testIsEvenOrOdd() {
         EvenOddValidator validator = new EvenOddValidator();

         // Test even numbers
         assertTrue(validator.isEvenOrOdd(2), "2 should be even");
         assertTrue(validator.isEvenOrOdd(4), "4 should be even");
         assertTrue(validator.isEvenOrOdd(0), "0 should be even");

         // Test odd numbers
         assertFalse(validator.isEvenOrOdd(1), "1 should be odd");
         assertFalse(validator.isEvenOrOdd(3), "3 should be odd");
         assertFalse(validator.isEvenOrOdd(-1), "-1 should be odd");
    }
}