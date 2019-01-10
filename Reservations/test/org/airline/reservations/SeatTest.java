package org.airline.reservations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeatTest {

	@Test
	void testSeat() {
		Seat testSeat1 = new Seat();		 
		assertEquals(10, testSeat1.getSeatNumber());
	}
	
	public void testSetSeatNumber() {
		
		Seat testSeat2 = new Seat();
		testSeat2.setSeatNumber(2);
		assertEquals(2, testSeat2.getSeatNumber());
		
	}

}
