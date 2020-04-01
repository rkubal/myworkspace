package com.secretescape.utility;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.secreteescape.utility.CurrencyConversionUtility;
import com.secretescape.model.CurrencyInfoDTO;


public class CurrencyConversionUtilityTest {
	
	@Test
	public void testGetRoundedAmount() {
		assertEquals("12.23889", CurrencyConversionUtility.getRoundedAmount(new Double("12.238888898")));
		assertEquals("12.23000", CurrencyConversionUtility.getRoundedAmount(new Double("12.23")));
		assertEquals("0.99000", CurrencyConversionUtility.getRoundedAmount(new Double(".99")));
	}

	@Test
	public void testGetLatestRates() {
		CurrencyInfoDTO  currencyInfoDTO = CurrencyConversionUtility.getLatestRates(CurrencyConversionUtility.readRates());
		assertEquals(mockCurrencyInfoDTO(), currencyInfoDTO);
	}

	
	public CurrencyInfoDTO mockCurrencyInfoDTO() {
		CurrencyInfoDTO  currencyInfoDTO = new CurrencyInfoDTO();
		currencyInfoDTO.setDate("2020-03-27");
	    currencyInfoDTO.setDateStr("2020-03-27");

		Map<String, Double> rates = new HashMap();
		rates.put("CAD", new Double(1.4334));
		rates.put("HKD", new Double(8.416));
		rates.put("ISK", new Double(137.7));
		rates.put("PHP", new Double(54.787));
	    JSONObject obj = new JSONObject(rates);
		currencyInfoDTO.setRates((Map<String, Double>)obj);
		return currencyInfoDTO;
	}
}
