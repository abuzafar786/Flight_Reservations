package org.airline.reservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			// create ticket and return info
			// repeat
		}
	}
}
