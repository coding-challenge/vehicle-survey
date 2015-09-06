/**
 *
 */
package com.aconex.challenge.vehicle.reports.count.average;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class AverageVehiclesPerHalfHourCountReport extends AbstractAverageVehicleCountTimeReport {

    private static final String HALF_HOUR_NAME = "HALF-HOUR";
    private static final String NAME = "AverageVehiclesPerHalfHourPerDirectionCount";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected long getTimeInterval() {
        return CONSTANTS.MILLIS.HALF_HOUR;
    }

    @Override
    protected String getTimeIntervalName() {
        return HALF_HOUR_NAME;
    }

}
