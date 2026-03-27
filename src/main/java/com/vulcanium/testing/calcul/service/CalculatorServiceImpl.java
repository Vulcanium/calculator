package com.vulcanium.testing.calcul.service;

import com.vulcanium.testing.calcul.domain.Calculator;
import com.vulcanium.testing.calcul.domain.model.CalculationModel;
import com.vulcanium.testing.calcul.domain.model.CalculationType;

public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    private final SolutionFormatter solutionFormatter;

    public CalculatorServiceImpl(Calculator calculator, SolutionFormatter solutionFormatter) {
        this.calculator = calculator;
        this.solutionFormatter = solutionFormatter;
    }

    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = switch (type) {
            case ADDITION -> calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case SUBSTRACTION ->
                    calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case MULTIPLICATION ->
                    calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case DIVISION -> calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            default -> throw new UnsupportedOperationException("Unsupported calculations");
        };

        calculationModel.setSolution(response);
        calculationModel.setFormattedSolution(solutionFormatter.format(response));

        return calculationModel;
    }

}
