package com.vulcanium.testing.calcul.service;

import com.vulcanium.testing.calcul.domain.Calculator;
import com.vulcanium.testing.calcul.domain.model.CalculationModel;
import com.vulcanium.testing.calcul.domain.model.CalculationType;

public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = switch (type) {
            case ADDITION -> calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case SUBSTRACTION -> calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case MULTIPLICATION ->
                    calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case DIVISION -> calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            default -> throw new UnsupportedOperationException("Unsupported calculations");
        };

        calculationModel.setSolution(response);
        return calculationModel;
    }

}
