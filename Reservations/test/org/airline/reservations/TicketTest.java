package org.airline.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testSetPassenger() {
		Ticket testTicket1 = new Ticket();
		Passenger testPassenger1 = new Passenger("German Jongewaard");
		testTicket1.setPassenger(testPassenger1);
		assertEquals("German Jongewaard", testTicket1.getPassenger().getName());
		
	}

}
