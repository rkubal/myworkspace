package com.secreteescape.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.secreteescape.utility.CurrencyConversionUtility;
import com.secretescape.model.ResultDTO;

public class TestCurrencyConversionService {

	@Test
	public void testGetAmountForLatestRatesPerType() {
		CurrencyConversionService currencyConversionService = new CurrencyConversionService();
		assertEquals(mockResultDTO(), currencyConversionService.getAmountForLatestRatesPerType("PHP", new Double(500)));

		assertEquals(new ResultDTO(),
				currencyConversionService.getAmountForLatestRatesPerType("XUUXX", new Double(500)));

		assertEquals(new ResultDTO(), currencyConversionService.getAmountForLatestRatesPerType(null, new Double(500)));

	}

	public static ResultDTO mockResultDTO() {
		ResultDTO result = new ResultDTO();
		result.setAmount("27393.50000");
		result.setCurrencyType("EUR");
		result.setDate(CurrencyConversionUtility.convertStringToDate("2020-03-27"));
		return result;
	}
}
