/**
 * 
 */
package com.aconex.challenge.vehicle;

/**
 * Holds the information about each mark on the rubber hose
 * 
 * @author Bharath Maturi
 *
 */
public class Record {
	
	// Direction on which the mark happened
	// FIXME find a better data structure
	private char direction;
	
	// time in milliseconds after midnight when 
	// the mark happened
	private long timestamp;

	/**
	 * @return the direction
	 */
	public char getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(char direction) {
		this.direction = direction;
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
