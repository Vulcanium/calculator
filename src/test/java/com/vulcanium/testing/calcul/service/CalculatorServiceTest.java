package com.vulcanium.testing.calcul.service;

import com.vulcanium.testing.calcul.domain.Calculator;
import com.vulcanium.testing.calcul.domain.model.CalculationModel;
import com.vulcanium.testing.calcul.domain.model.CalculationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    // Calculator IS CALLED BY CalculatorService
    @Mock
    Calculator calculator = new Calculator();

    CalculatorService calculatorServiceUnderTest;

    /*------------------------------- Before tests --------------------------------------*/

    @BeforeEach
    public void initCalculatorService() {
        calculatorServiceUnderTest = new CalculatorServiceImpl(calculator);
    }

    /*-------------------------------- Tests -------------------------------------*/

    @Test
    public void calculate_shouldUseCalculator_forAddition() {

        // GIVEN
        when(calculator.add(1, 2)).thenReturn(3);

        // WHEN
        final int result = calculatorServiceUnderTest
                .calculate(new CalculationModel(CalculationType.ADDITION, 1, 2))
                .getSolution();

        // THEN
        verify(calculator).add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldUseCalculator_forSubstraction() {

        // GIVEN
        when(calculator.sub(1, 2)).thenReturn(-1);

        // WHEN
        final int result = calculatorServiceUnderTest
                .calculate(new CalculationModel(CalculationType.SUBSTRACTION, 1, 2))
                .getSolution();

        // THEN
        verify(calculator).sub(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void calculate_shouldUseCalculator_forMultiplication() {

        // GIVEN
        when(calculator.multiply(3, 2)).thenReturn(6);

        // WHEN
        final int result = calculatorServiceUnderTest
                .calculate(new CalculationModel(CalculationType.MULTIPLICATION, 3, 2))
                .getSolution();

        // THEN
        verify(calculator).multiply(3, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calculate_shouldUseCalculator_forDivision() {

        // GIVEN
        when(calculator.divide(2, 2)).thenReturn(1);

        // WHEN
        final int result = calculatorServiceUnderTest
                .calculate(new CalculationModel(CalculationType.DIVISION, 2, 2))
                .getSolution();

        // THEN
        verify(calculator).divide(2, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculate_shouldUseCalculator_forAnyAddition() {

        // GIVEN
        Random rand = new Random();
        when(calculator.add(any(Integer.class), any(Integer.class))).thenReturn(3);

        // WHEN
        final int result = calculatorServiceUnderTest
                .calculate(new CalculationModel(CalculationType.ADDITION, rand.nextInt(), rand.nextInt()))
                .getSolution();

        // THEN
        verify(calculator, times(1)).add(any(Integer.class), any(Integer.class));
        verify(calculator, never()).sub(any(Integer.class), any(Integer.class));
        verify(calculator, never()).multiply(any(Integer.class), any(Integer.class));
        verify(calculator, never()).divide(any(Integer.class), any(Integer.class));

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldThrowArithmeticException_forDivisionByZero() {

        // GIVEN
        when(calculator.divide(2, 0)).thenThrow(new ArithmeticException());

        // WHEN
        assertThrows(ArithmeticException.class, () -> {
            calculatorServiceUnderTest.calculate(new CalculationModel(CalculationType.DIVISION, 2, 0));
        });

        // THEN
        verify(calculator, times(1)).divide(2, 0);
    }
}
