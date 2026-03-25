package com.vulcanium.testing;

public class ConversionCalculator {

    // Constants for temperature conversion
    private static final double BASE_FAHRENHEIT = 32.0;
    private static final double CELSIUS_FAHRENHEIT_CONVERSION_FACTOR = 9.0 / 5.0;

    // Constants for volume conversion
    private static final double LITER_TO_GALLON_MULTIPLIER = 0.264172;

    // Exponent for calculating the area of a disk
    private static final double POWER_OF_RADIUS = 2.0;

    /**
     * Convert Celsius to Fahrenheit.
     *
     * @param celsiusTemperature to convert
     * @return Fahrenheit temperature.
     */
    public Double celsiusToFahrenheit(Double celsiusTemperature) {
        return (celsiusTemperature * CELSIUS_FAHRENHEIT_CONVERSION_FACTOR) + BASE_FAHRENHEIT;
    }

    /**
     * Convert Fahrenheit to Celsius.
     *
     * @param fahrenheitTemperature to convert
     * @return Celsius temperature
     */
    public Double fahrenheitToCelsius(Double fahrenheitTemperature) {
        return (fahrenheitTemperature - BASE_FAHRENHEIT) * CELSIUS_FAHRENHEIT_CONVERSION_FACTOR;
    }

    /**
     * Convert volume to gallons.
     *
     * @param literVolume to convert
     * @return volume to gallons
     */
    public Double litersToGallons(Double literVolume) {
        return Math.ceil(literVolume * LITER_TO_GALLON_MULTIPLIER);
    }

    /**
     * Convert a radius into the area of a circle.
     *
     * @param radius of circle
     * @return area of circle
     */
    public Double radiusToAreaOfCircle(Double radius) {
        return Math.PI * Math.pow(radius, POWER_OF_RADIUS);

    }
}
