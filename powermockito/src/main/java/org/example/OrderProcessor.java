package org.example;

public class OrderProcessor {
    public double processOrder(double amount) {
        double discout = calculateDiscout(amount);
        return amount - discout;
    }

    //with 10% of discout
    private double calculateDiscout(double amount) {
        return amount * 0.1;
    }
}
