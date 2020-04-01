package com.secretescape.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.secreteescape.utility.CurrencyConversionUtility;

public class CurrencyInfoDTO implements Comparable<CurrencyInfoDTO> {

	Date date;
	String dateStr;
	Map<String, Double> rates;

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateStr == null) ? 0 : dateStr.hashCode());
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyInfoDTO other = (CurrencyInfoDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateStr == null) {
			if (other.dateStr != null)
				return false;
		} else if (!dateStr.equals(other.dateStr))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		return true;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String dateStr) {
		this.setDateStr(dateStr);

		this.date = CurrencyConversionUtility.convertStringToDate(dateStr);
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyInfoDTO [datestr=" + getDateStr() + ",date=" + getDate() + ", rates=" + getRates() + "]";
	}

	public int compareTo(CurrencyInfoDTO o) {
		// TODO Auto-generated method stub
		return o.getDate().compareTo(getDate());
	}

}
