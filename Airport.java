package com.airport;

public class Airport {
	private String city;
	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getAirportname() {
		return airportname;
	}



	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}



	public String getIata() {
		return iata;
	}



	public void setIata(String iata) {
		this.iata = iata;
	}



	private String airportname;
	private String iata;
	
	
	
	@Override
	public String toString(){
		return "\nIata="+getIata()+"::Name"+getAirportname()+"::city="+getCity();
	
	
	
	

}}
