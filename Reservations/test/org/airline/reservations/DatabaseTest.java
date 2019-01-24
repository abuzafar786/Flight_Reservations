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
	
	@Test
	public void testFlight() {
		Database testDB3 = new Database();
		testDB3.addFlight(1000, "Los Angeles", "Chicago");
		assertEquals(1, testDB3.getFlights().size());
	}
	
 	@Test
	public void testPassegner() {
		Database testDB4 = new Database();
		testDB4.addPassenger("German Jongewaard");
		assertEquals(1,testDB4.getPassengers().size());
	}
 	
 	@Test
 	public void testAddNewPassenger() {
 		Database testDB6 = new Database();
		boolean result1 = testDB6.addPassenger("German Jongewaard");
		assertEquals(false, result1);
		
		boolean result2 = testDB6.addPassenger("German Jongewaard");
		assertEquals(true, result2);
		
 		 
 	}
 	
 	@Test
 	public void testBootstrap() {
 		Database testDB7 = new Database();
 		testDB7.bootstrap();
 		assertEquals(6, testDB7.getSeats().size());
 		assertEquals(4, testDB7.getFlights().size());
 		
 	}
}
