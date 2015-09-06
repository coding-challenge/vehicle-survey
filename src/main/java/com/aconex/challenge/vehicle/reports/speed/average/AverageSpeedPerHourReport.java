/**
 *
 */
package com.aconex.challenge.vehicle.reports.speed.average;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class AverageSpeedPerHourReport extends AbstractAverageSpeedPerTimeReport {

    private static final String HOUR_NAME = "HOUR";
    private static final String NAME = "AverageVehiclesSpeedPerHour";

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
