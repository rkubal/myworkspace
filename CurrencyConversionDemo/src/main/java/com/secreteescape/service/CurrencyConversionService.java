package com.secreteescape.service;

import java.util.Map;

import com.secreteescape.utility.CurrencyConversionUtility;
import com.secretescape.model.CurrencyInfoDTO;
import com.secretescape.model.ResultDTO;

public class CurrencyConversionService {

	ResultDTO getAmountForLatestRatesPerType(String currencyType, Double amount) {
		ResultDTO result = new ResultDTO();
		CurrencyInfoDTO currencyInfo = CurrencyConversionUtility.getLatestRates(CurrencyConversionUtility.readRates());
		

		Map<String, Double> typeRateMapping = currencyInfo.getRates();
		if (typeRateMapping.containsKey(currencyType)) {
			for (String type : typeRateMapping.keySet()) {
				if (type.equalsIgnoreCase(currencyType)) {
					// set currency type
					result.setCurrencyType("EUR");
					// set amount, multiplying the amount by the currency conversion rate and rounding it to precision of 5 decimal points
					result.setAmount(CurrencyConversionUtility.getRoundedAmount(amount*(typeRateMapping.get(currencyType))));
					// set date
					result.setDate(currencyInfo.getDate());
				}
			}
		}

		return result;

	}
}
