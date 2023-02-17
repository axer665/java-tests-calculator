package org.example;

public class Calculator {
    public int additional (int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication (int a, int b) {
        return a * b;
    }

    public double divide (int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Нельзя делить на ноль");
            }
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }
        double result = (double) a / (double) b;
        return result;
    }

    public int divideInt (int a, int b) {
        return a / b;
    }
}
