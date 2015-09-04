/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class VehiclesPerQuarterHourCountReport extends AbstractDayVehicleCountTimeReport {

    private static final String INTERVAL_NAME = "QUARTER-HOUR";
    private static final String NAME = "VehiclesPerQuarterHourPerDirectionCount";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected long getTimeInterval() {
        return CONSTANTS.MILLIS.QUARTER_HOUR;
    }

    @Override
    protected String getTimeIntervalName() {
        return INTERVAL_NAME;
    }

}
