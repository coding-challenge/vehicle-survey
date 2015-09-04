/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class VehiclesPerSessionCountReport extends AbstractDayVehicleCountTimeReport {

    private static final String SESSION_NAME = "SESSION";
    private static final String NAME = "VehiclesPerSessionPerDirectionCount";
    private static final String MORNING = "MORNING ";
    private static final String EVENING = "EVENING ";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected long getTimeInterval() {
        return CONSTANTS.MILLIS.HALFDAY;
    }

    @Override
    protected String getTimeIntervalName() {
        return SESSION_NAME;
    }

    @Override
    public String getHoursFromTimestamp(long timestamp) {
        if (timestamp == 0) {
            return MORNING;
        } else {
            return EVENING;
        }
    }

}
