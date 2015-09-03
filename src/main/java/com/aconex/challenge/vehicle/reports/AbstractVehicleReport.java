/**
 *
 */
package com.aconex.challenge.vehicle.reports;

/**
 * @author bmaturi
 */
public abstract class AbstractVehicleReport implements VehicleReport {

    // using System.out , Can be changed to use any logger
    // when required
    protected void writeLog(String log) {
        System.out.println(log);
    }

}
