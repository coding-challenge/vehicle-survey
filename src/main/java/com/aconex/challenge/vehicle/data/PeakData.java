/**
 *
 */
package com.aconex.challenge.vehicle.data;

/**
 * @author bmaturi
 */
public class PeakData {

    private int NoOfVehicles;

    private long timestamp;

    public PeakData() {

    }

    public PeakData(long timestamp, int noOfVehicles) {
        this.timestamp = timestamp;
        this.NoOfVehicles = noOfVehicles;
    }

    /**
     * @return the noOfVehicles
     */
    public int getNoOfVehicles() {
        return NoOfVehicles;
    }

    /**
     * @param noOfVehicles
     *            the noOfVehicles to set
     */
    public void setNoOfVehicles(int noOfVehicles) {
        NoOfVehicles = noOfVehicles;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
