package com.vulcanium.testing.calcul.service;

import java.util.List;
import java.util.stream.Stream;

import com.vulcanium.testing.calcul.domain.model.CalculationModel;

public interface BatchCalculatorService {
	public List<CalculationModel> batchCalculate(Stream<String> operations);
}
