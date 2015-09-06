/**
 *
 */
package com.aconex.challenge.vehicle.reports.distance.average;

import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.reports.count.average.AbstractAverageVehicleCountTimeReport;

/**
 * @author bmaturi
 */
public class AverageDistancePerHourReport extends AbstractAverageVehicleCountTimeReport {

    private static final String HOUR_NAME = "HOUR";
    private static final String NAME = "AverageVehiclesDistancePerHourInMeters";

    /*
     * (non-Javadoc)
     * @see com.intercheck.challenge.vehicle.reports.VehicleReport#getName()
     */
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected long getTimeInterval() {
        return CONSTANTS.MILLIS.HOUR;
    }

    @Override
    protected String getTimeIntervalName() {
        return HOUR_NAME;
    }

}
