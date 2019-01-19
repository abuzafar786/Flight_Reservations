package org.airline.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDatabase() {
		Database testDB = new Database(); 
		assertEquals(0, testDB.getSeats().size());
		assertEquals(0, testDB.getFlights().size());
		assertEquals(0, testDB.getPassengers().size());
		assertEquals(0, testDB.getTickets().size());
	}

	@Test
	public void testAddSeat() {
		Database testDB2 = new Database();
		testDB2.addSeat(4);
		assertEquals(1, testDB2.getSeats().size());
	}
}