package com.vulcanium.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public void longCalculation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> digits = new HashSet<>();
        String numberString = String.valueOf(number).replace("-", "");

        for (int i = 0; i < numberString.length(); i++) {
            digits.add(Integer.parseInt(numberString.substring(i, i + 1)));
        }

        return digits;
    }
}
