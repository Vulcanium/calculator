package com.vulcanium.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    /*------------------------------- Before tests --------------------------------------*/

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Initializing stopwatch...");
        startedAt = Instant.now();
    }

    @BeforeEach
    public void initCalculator() {
        System.out.println("Initializing Calculator...");
        calculatorUnderTest = new Calculator();
    }

    /*-------------------------------- Tests -------------------------------------*/

    @Test
    public void add_shouldReturnTheSum_ofTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int sum = calculatorUnderTest.add(a, b);

        // Assert
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        // Arrange
        int a = 3;
        int b = 2;

        // Act
        int product = calculatorUnderTest.multiply(a, b);

        // Assert
        assertThat(product).isEqualTo(6);
    }

    @ParameterizedTest(name = "{0} * 0 should return zero")
    @ValueSource(ints = {1, 2, 42, 1001, 5089})
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange
        // Nothing to do here

        // Act
        int product = calculatorUnderTest.multiply(arg, 0);

        // Assert
        assertThat(product).isZero();
    }

    @ParameterizedTest(name = "{0} + {1} should return {2}")
    @CsvSource({"1, 1, 2", "2, 3, 5", "42, 57, 99"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectedResult) {
        // Arrange
        // Nothing to do here

        // Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @Timeout(1)
    public void longCalculation_shouldComputeInLessThan1Second() {
        // Arrange
        // Nothing to do here

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        // Nothing to do here
    }

    @Test
    public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveIntegers() {

        // GIVEN
        int number = 95897;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
    }

    @Test
    public void digitsSet_shouldReturnsTheSetOfDigits_ofNegativeIntegers() {

        // GIVEN
        int number = -124432;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(1, 2, 3, 4);
    }

    @Test
    public void digitsSet_shouldReturnsTheSetOfZero_ofZero() {

        // GIVEN
        int number = 0;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactly(0);
    }

    /*-------------------------------- After tests -------------------------------------*/

    @AfterEach
    public void undefineCalculator() {
        System.out.println("Undefining Calculator...");
        calculatorUnderTest = null;
    }

    @AfterAll
    public static void initFinishingTime() {
        System.out.println("Finishing stopwatch...");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println("Duration of the tests: " + duration + " ms");
    }
}
