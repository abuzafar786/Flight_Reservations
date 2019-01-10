package org.airline.reservations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PassengerTest {

	@Test
	void testPassenger() {
		Passenger testPassenger1 = new Passenger();
		String result = testPassenger1.getName();
		assertEquals("Unknown name", result);
	}

	@Test
	void testSetName() {
		Passenger testPassenger2 = new Passenger();
		testPassenger2.setName("Germán jongewaard");
		assertEquals("Germán jongewaard", testPassenger2.getName());
	}

}







