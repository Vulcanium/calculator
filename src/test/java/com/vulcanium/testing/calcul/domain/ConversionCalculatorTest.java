package com.vulcanium.testing.calcul.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.withinPercentage;

@Tag("ConversionTests")
@DisplayName("To be able to convert between different units.")
public class ConversionCalculatorTest {

    private ConversionCalculator conversionCalculatorUnderTest;

    /*------------------------------- Before tests --------------------------------------*/

    @BeforeEach
    public void initConversionCalculator() {
        System.out.println("Initializing ConversionCalculator under test...");
        conversionCalculatorUnderTest = new ConversionCalculator();
    }

    /*-------------------------------- Tests -------------------------------------*/

    @Nested
    @Tag("TemperatureTests")
    @DisplayName("To be able to convert temperatures")
    class TemperatureTests {
        @Test
        @DisplayName("Given a temperature of 0°C, when converting to °F, we obtain 32°F.")
        public void celsiusToFahrenheit_returnsAFahrenheitTemperature_whenCelsiusIsZero() {
            Double actualFahrenheit = conversionCalculatorUnderTest.celsiusToFahrenheit(0.0);
            assertThat(actualFahrenheit).isCloseTo(32.0, withinPercentage(0.01));
        }

        @Test
        @DisplayName("Given a temperature of 32°F, when converting to °C, we obtain 0°C.")
        public void fahrenheitToCelsius_returnsZeroCelsiusTemperature_whenThirtyTwo() {
            Double actualCelsius = conversionCalculatorUnderTest.fahrenheitToCelsius(32.0);
            assertThat(actualCelsius).isCloseTo(0.0, withinPercentage(0.01));
        }
    }

    @Test
    @DisplayName("Given a volume of 3.78541 liters, when converted to gallons, we obtain 1 gallon.")
    public void litersToGallons_returnsOneGallon_whenConvertingTheEquivalentLiters() {
        Double actualLitres = conversionCalculatorUnderTest.litersToGallons(3.78541);
        assertThat(actualLitres).isCloseTo(1.0, withinPercentage(0.01));
    }

    @Test
    @DisplayName("The area of a circle with radius 1 must be equal to PI.")
    public void radiusToAreaOfCircle_returnsPi_whenWeHaveARadiusOfOne() {
        Double actualArea = conversionCalculatorUnderTest.radiusToAreaOfCircle(1.0);
        assertThat(actualArea).isCloseTo(Math.PI, withinPercentage(0.01));
    }
}
