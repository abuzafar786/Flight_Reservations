package org.airline.reservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Console {

	public static void main(String[] args) {
		// initialize database
		Database prodDB = new Database();
		prodDB.bootstrap(); 
		
		// initialize console
		boolean always = true;
		BufferedReader screenInput = new BufferedReader(new InputStreamReader(System.in));
		String passengerName = null;
		int flightNumber = 0;
		LocalDate departureDate = LocalDate.now();
		int seatNumber = 0;
		int tamanioSeats = 0;;
		
		
		// loop
		while(always) {
			// ask for passengerName and add
			System.out.println("Enter passenger: ");
			 			try {
				passengerName = screenInput.readLine();
				
			} catch (IOException e) {
				System.out.println("Sorry, I don't understand.");
			}
			
			boolean result = prodDB.addPassenger(passengerName);
			if(result) {
				System.out.println("Welcome back " + passengerName);
			} else {
				System.out.println("Welcome " + passengerName);
			}
			//always = false;
			
			// show flights and ask for flight
			System.out.println("\nHere are the available flights:");
			for(Flight item : prodDB.getFlights()) {
				System.out.println(item);
			}
			System.out.println("Enter the flight number to book: ");
			try {
				flightNumber = Integer.parseInt(screenInput.readLine());
			} catch (IOException e) {
				System.out.println("Please enter a flight number.");
			}catch (NumberFormatException e) {
				System.out.println("That wasn't a number.");
			}
			// show available seats and ask
			System.out.println("\nAssuming you are flying today,");
			System.out.println("Here are the available seats on that flight: ");
			ArrayList<Seat> openSeats = prodDB.getOpenSeats(departureDate, flightNumber);
			tamanioSeats = openSeats.size();
			if(!openSeats.isEmpty()){				
			
				for(Seat item : openSeats) {	
					 
					 
					if(item.getSeatNumber() < tamanioSeats ) {
						System.out.println(item.getSeatNumber() + ", ");
					} else {
						System.out.println(item.getSeatNumber() + ".");
					}
					 
				}
				
				System.out.println("\nEnter the seat you want: ");
				
			}else {
				System.out.println("\nAll the Seats are complete, Thanks.");				
			}
			 
			try {
				seatNumber = Integer.parseInt(screenInput.readLine());
			} catch(IOException e) {
				System.out.println("Please enter a seat number");
			}
			
			// create ticket and return info
			String ticketInfo = prodDB.addTicket(departureDate, passengerName, flightNumber, seatNumber);
			System.out.println("\nReservation Successful. Here are your details:");
			System.out.println(ticketInfo + "\n");
			// repeat
		}
	}
}
