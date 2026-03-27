package com.vulcanium.testing.calcul.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private Calculator calculatorUnderTest;

    @BeforeEach
    public void initCalculator() {
        calculatorUnderTest = new Calculator();
    }

    @Test
    @Disabled("Ambiguous test and out of bounds for the double type")
    public void subTwoDoubleNumbers_shouldReturnsTheCorrectAnswer() {
        // GIVEN

        // WHEN
        double result = calculatorUnderTest.sub(1.0000000001, 1.0);

        // THEN
        if (result != 0.0000000001) {
            throw new AssertionError(String.format("Erreur :\nAttendu :  0,0000000001\n Résultat : %.10f", result));
        }

    }
}
