package org.airline.reservations;

import java.time.LocalDate;

public class Ticket {
	
	//fields
	LocalDate departureDate;
	
	Passenger passenger;
	
	Flight flight;
	
	Seat seat;
	
	//Constructor
	public Ticket() {		
		departureDate = LocalDate.now();
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	//getters & setters
	

}
