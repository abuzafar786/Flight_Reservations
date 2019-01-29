package org.airline.reservations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	//fields
	private ArrayList<Seat> seats;
	private ArrayList<Flight> flights;
	private ArrayList<Passenger> passengers;
	private ArrayList<Ticket> tickets;
	
	private static Logger databaseLog = Logger.getLogger(Database.class.getName());
	private static ConsoleHandler logScreen = new ConsoleHandler();

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
	
	
	//setters
	public void setLogging() {
		databaseLog.addHandler(logScreen);
		databaseLog.setLevel(Level.FINE);
		logScreen.setLevel(Level.FINE);
	}
	
	
	public void addSeat(int seatNumber) {
		seats.add(new Seat(seatNumber));		
	}

	public void addFlight(int flightNumber, String departureCity, String arrivalCity) {
		flights.add(new Flight(flightNumber, departureCity, arrivalCity));		
	}

	public boolean addPassenger(String passengerName) {
		boolean passengerExists = false;
		
		for(Passenger item : getPassengers()) {
			if(passengerName.equals(item.getName())) {
				passengerExists = true;
			}
		}
		
		if(passengerExists == false) {
			passengers.add(new Passenger(passengerName));				
		}
		
		 
		return passengerExists;
	}
	
	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, int seatNumber) {
		//find the passenger object
		Passenger ticketPassenger = null;
		for(Passenger item : getPassengers()) {
			if(passengerName.equals(item.getName())) {
				ticketPassenger = item;
			}
		}
		//find flight object
		Flight ticketFlight = null;
		for(Flight item : getFlights()) {
			if(flightNumber == item.getFlightNumber()) {
				ticketFlight = item;
			}
		}
		//find seat object
		Seat ticketSeat = null;
		for(Seat item : getSeats()) {
			if(seatNumber == item.getSeatNumber()) {
				ticketSeat = item;
			}
		}
		
		Ticket temTicket = new Ticket();
		temTicket.setDepartureDate(departureDate);
		temTicket.setPassenger(ticketPassenger);
		temTicket.setFlight(ticketFlight);
		temTicket.setSeat(ticketSeat);
		tickets.add(temTicket);
		return temTicket.toString();		
	}
	
	public ArrayList<Seat> getOpenSeats(LocalDate departureDate, int flightNumber){
		ArrayList<Seat> openSeats = getSeats(); 
		for(Ticket item : getTickets()) {
			if(departureDate.equals(item.getDepartureDate()) && flightNumber == item.getFlight().getFlightNumber()) {
				openSeats.remove(item.getSeat());
			}
		}
		return openSeats;
	}	
	
	public void bootstrap() {
		addSeat(1);
		addSeat(2);
		addSeat(3);
		addSeat(4);
		addSeat(5);
		addSeat(6);
		
		addFlight(1000, "Los Angeles", "Chicago");
		addFlight(1010, "Chicago", "New York");
		addFlight(2000, "New York", "Chicago");
		addFlight(2010, "Chicago", "Los Angeles");
		
	}
	
	public void bootstrapCSV() {
		try {
			BufferedReader flightImport = new BufferedReader(new FileReader("/home/german/git/flightreservations/Reservations/import/flights.csv"));
			String flightLine;
			while((flightLine = flightImport.readLine()) != null) {
				System.out.println(flightLine);
			}
			flightImport.close(); 	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exportSeats() {
		try {
			BufferedWriter seatExport = new BufferedWriter(new FileWriter("/home/german/git/flightreservations/Reservations/export/seats.csv"));
			for(Seat item : getSeats()) {
				seatExport.write(item.toString() + "\n");
			}			 
			seatExport.close();
			System.out.println("Export file created");			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
