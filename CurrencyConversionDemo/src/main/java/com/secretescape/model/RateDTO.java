package com.secretescape.model;

import java.util.Collections;
import java.util.List;

public class RateDTO {

	List<CurrencyInfoDTO> currencyList ;

	public List<CurrencyInfoDTO> getCurrencyList() {
		Collections.sort(currencyList);
		return currencyList;
		
	}

	public void setCurrencyList(List<CurrencyInfoDTO> currencyList) {
		this.currencyList = currencyList;
	}

	@Override
	public String toString() {
		return "RateDTO [currencyList=" + currencyList + "]";
	}
	
	
	
	
	
}
