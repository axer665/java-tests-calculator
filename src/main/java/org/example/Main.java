package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double divide = calculator.divide(5, 0);
        System.out.println(divide);
    }
}