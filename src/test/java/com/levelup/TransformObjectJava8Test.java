package com.levelup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import com.levelup.domain.GoogleGeoLocation;
import com.levelup.domain.MyLocation;

public class TransformObjectJava8Test {

	Function<GoogleGeoLocation, MyLocation> externalToMyLocation = new Function<GoogleGeoLocation, MyLocation>() {

		public MyLocation apply(GoogleGeoLocation t) {
			MyLocation myLocation = new MyLocation();
			myLocation.setCountryCode(Double.valueOf(t
					.getHomeMobileCountryCode()));
			myLocation.setMyCarrier(t.getCarrier());
			myLocation.setMyRadioType(t.getRadioType());
			myLocation.setNetworkCode(Double.valueOf(t
					.getHomeMobileNetworkCode()));
			return myLocation;
		}
	};

	@Test
	public void convertSingleObject() {
		
		GoogleGeoLocation googleLocation = new GoogleGeoLocation(310, 410,
				"gsm", "Vodafone");
		
		MyLocation myLocation = externalToMyLocation.apply(googleLocation);
		
		System.out.println(myLocation);
		
	}
	
	@Test
	public void convertCollection() {
		
		GoogleGeoLocation googleLocation1 = new GoogleGeoLocation(310, 410,
				"gsm", "Vodafone");

		GoogleGeoLocation googleLocation2 = new GoogleGeoLocation(222, 777,
				"gprs", "Verizon");

		GoogleGeoLocation googleLocation3 = new GoogleGeoLocation(111, 234,
				"gsm", "Sprint");

		GoogleGeoLocation googleLocation4 = new GoogleGeoLocation(345, 567,
				"gprs", "Us Cell");
		
		List<GoogleGeoLocation> gLocations = new ArrayList<GoogleGeoLocation>();
		gLocations.add(googleLocation1);
		gLocations.add(googleLocation2);
		gLocations.add(googleLocation3);
		gLocations.add(googleLocation4);

		List<MyLocation> myLocations = gLocations.stream()
				.map(externalToMyLocation)
				.collect(Collectors.<MyLocation> toList());

		System.out.println(myLocations);
	}
	
	

}
