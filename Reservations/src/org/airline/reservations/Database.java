package org.airline.reservations;

import java.util.ArrayList;

public class Database {

	//fields
	private ArrayList<Seat> seats;
	private ArrayList<Flight> flights;
	private ArrayList<Passenger> passengers;
	private ArrayList<Ticket> tickets;

	//constructor
	public Database() {
		seats = new ArrayList<Seat>();
		flights = new ArrayList<Flight>();
		passengers = new ArrayList<Passenger>();
		tickets = new ArrayList<Ticket>();
	}

	//getters
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void addSeat(int seatNumber) {
		seats.add(new Seat(seatNumber));		
	}

	public void addFlight(int flightNumber, String departureCity, String arrivalCity) {
		flights.add(new Flight(flightNumber, departureCity, arrivalCity));
		
	}
	

}
