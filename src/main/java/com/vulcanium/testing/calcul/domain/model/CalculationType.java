package com.vulcanium.testing.calcul.domain.model;

public enum CalculationType {
    ADDITION,
    MULTIPLICATION,
    DIVISION,
    SUBSTRACTION,
    CONVERSION;

    public static CalculationType fromSymbol(String operation) {
        return switch (operation) {
            case "+" -> ADDITION;
            case "-" -> SUBSTRACTION;
            case "/" -> DIVISION;
            case "*", "x" -> MULTIPLICATION;
            default -> throw new UnsupportedOperationException("Not implemented yet");
        };
    }
}
