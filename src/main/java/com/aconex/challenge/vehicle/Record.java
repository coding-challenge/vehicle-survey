/**
 * 
 */
package com.aconex.challenge.vehicle;

/**
 * Holds the information about each mark on the rubber hose
 * 
 * @author bmaturi
 *
 */
public class Record {
	
	// Direction on which the mark happened
	private Direction direction;
	
	// time in milliseconds after midnight when 
	// the mark happened
	private long timestamp;

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
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
