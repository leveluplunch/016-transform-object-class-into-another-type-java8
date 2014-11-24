package com.levelup.domain;

public class MyLocation {
	
	private Double countryCode;
	private Double networkCode;
	private String myRadioType;
	private String myCarrier;
	
	public Double getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Double countryCode) {
		this.countryCode = countryCode;
	}
	public Double getNetworkCode() {
		return networkCode;
	}
	public void setNetworkCode(Double networkCode) {
		this.networkCode = networkCode;
	}
	public String getMyRadioType() {
		return myRadioType;
	}
	public void setMyRadioType(String myRadioType) {
		this.myRadioType = myRadioType;
	}
	public String getMyCarrier() {
		return myCarrier;
	}
	public void setMyCarrier(String myCarrier) {
		this.myCarrier = myCarrier;
	}
	
	@Override
	public String toString() {
		return "MyLocation [countryCode=" + countryCode + ", networkCode="
				+ networkCode + ", myRadioType=" + myRadioType + ", myCarrier="
				+ myCarrier + "]";
	}

}
