/**
 *
 */
package com.aconex.challenge.vehicle.reports.count.average;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
class AverageVehiclesPerHourCountReport extends AbstractAverageVehicleCountTimeReport {

    private static final String HOUR_NAME = "HOUR";
    private static final String NAME = "AverageVehiclesPerHourPerDirectionCount";

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
