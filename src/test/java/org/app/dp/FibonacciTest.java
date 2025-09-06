package org.app.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacci() {
        assertEquals(8, Fibonacci.fibonacci(6));
        assertEquals(13, Fibonacci.fibonacci(7));
        assertEquals(21, Fibonacci.fibonacci(8));
    }

    @Test
    void fibonacciTab() {
        assertEquals(8, Fibonacci.fibonacciTab(6));
        assertEquals(13, Fibonacci.fibonacciTab(7));
        assertEquals(21, Fibonacci.fibonacciTab(8));
        assertEquals(1, Fibonacci.fibonacciTab(1));
    }
}