/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class VehiclesPerTwentyMinutesCountReport extends AbstractDayVehicleCountTimeReport {

    private static final String INTERVAL_NAME = "TWENTY-MINUTES";
    private static final String NAME = "VehiclesPerTwentyMinutesPerDirectionCount";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected long getTimeInterval() {
        return CONSTANTS.MILLIS.TWENTY_MINUTES;
    }

    @Override
    protected String getTimeIntervalName() {
        return INTERVAL_NAME;
    }

}
