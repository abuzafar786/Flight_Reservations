package org.airline.reservations;

public class Seat {
	
	//fields
		private int seatNumber; //Passenger name
		
		//constructor
		public Seat() {
			
			setSeatNumber(10);		
			
		}
		
		public Seat(int seatNumber) {
			
			this.seatNumber = seatNumber;
			
		}
		

		public int getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(int seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public String toString() {
			return "Seat: " + this.getSeatNumber();			
		}
}
