/* Passenger.java
 * Written by Germán Jongewaard
 * We will keep the passenger as simple 
 * as possible and assume that all
 * passenger names are unique.
 */

package org.airline.reservations;

public class Passenger {
	
	//fields
	private String name; //Passenger name
	
	//constructor
	public Passenger() {
		
		this.name = "Unknown name";		
		
	}
	
	//getters and setters
	public String getName() {
		return name;		
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String toString() {
		
		return "Passenger: " + this.getName();
		
	}

}
