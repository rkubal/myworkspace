package com.secreteescape.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.secretescape.model.CurrencyInfoDTO;
import com.secretescape.model.RateDTO;

public class CurrencyConversionUtility {

	public static String getRoundedAmount(Double amount) {

		String strDouble = String.format("%.5f", amount);
		System.out.println("formatted amount is::" + strDouble);
		return strDouble;

	}

	public static CurrencyInfoDTO getLatestRates(JSONObject rates) {
		Set<String> keySet = rates.keySet();
		CurrencyInfoDTO currencyInfoDTO = null;
		List<CurrencyInfoDTO> list = new ArrayList<>();
		for (String k : keySet) {
			currencyInfoDTO = new CurrencyInfoDTO();
			String key = k;
			if (rates.get(key) instanceof JSONObject) {
				currencyInfoDTO.setDate(key);
				currencyInfoDTO.setRates((Map<String, Double>) rates.get(key));
				list.add(currencyInfoDTO);

			}
		}
		RateDTO rate = new RateDTO();
		rate.setCurrencyList(list);
		currencyInfoDTO = rate.getCurrencyList().get(0);
		System.out.println("latest rates are:::::::::::" + currencyInfoDTO);
		return currencyInfoDTO;
	}

	public static JSONObject readRates() {
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		JSONObject rates = null;
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/rates.json"));
			object = (JSONObject) obj;
			System.out.println("object:::" + object);
			rates = (JSONObject) object.get("rates");
			System.out.println("rates:::" + rates);
			return rates;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rates;
	}

	public static Date convertStringToDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		System.out.println("date converted is::" + new Date(date.getTime()));
		return new Date(date.getTime());

	}
}
