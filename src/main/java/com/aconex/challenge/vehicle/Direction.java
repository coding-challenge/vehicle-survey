/**
 * 
 */
package com.aconex.challenge.vehicle;

/**
 * Enumeration to indicate the direction of the 
 * records.
 * @author bmaturi
 *
 */
public enum Direction {
	
	A("DIRECTION-A"), B("DIRECTION-B");
	
	private final String value;
	
	Direction(String value) {
		this.value = value;
	}
	
	public static Direction fromValue (String value) {
		return valueOf(value.toUpperCase());
	}
	
	@Override
    public String toString() {
        return this.value;
    }

}
