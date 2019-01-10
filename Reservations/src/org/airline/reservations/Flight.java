/* Flight.java
 * Developer by Germán Jongewaard 
 */

package org.airline.reservations;

public class Flight {
	
	//fields
	private String departureCity;
	private String arrivalCity;
	private int flightNumber;
	
	//constructor
	public Flight () {
		
		this.departureCity = "Unknown Departure City";
		this.arrivalCity = "Unknown Arrival City";
		this.flightNumber = 100;
		
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	
	

}
