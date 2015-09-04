/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import java.util.List;
import java.util.Map;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;

/**
 * @author bmaturi
 */
public abstract class AbstractDayVehicleCountTimeReport extends AbstractVehicleCountTimeReport {

    @Override
    public void runReport(VehicleRecordDataAccess vehicleDataAccess) {
        final long timeInterval = getTimeInterval();

        writeLog(getReportHeader());
        for (final Day day : getDays()) {
            // report per Day header
            writeHeaderLog(day.name());
            // table header
            writeLog(getTableHeader());

            printReport(timeInterval, vehicleDataAccess, day);

            // table footer
            writeLog(getTableFooter());
        }
        writeLog(getReportFooter());
    }

    private void printReport(long timeInterval, VehicleRecordDataAccess vehicleDataAccess, Day day) {
        for (long startTime = 0; startTime < CONSTANTS.MILLIS.DAY; startTime += timeInterval) {

            final StringBuffer sb = new StringBuffer("|  " + getHoursFromTimestamp(startTime) + " |");
            for (final Direction direction : Direction.values()) {
                final Map<Day, List<VehicleRecord>> vehicleRecords = vehicleDataAccess.findRecordsInRangeAndDirection(
                        startTime, startTime + timeInterval, direction);
                final List<VehicleRecord> dayVehicleRecords = vehicleRecords.get(day);
                final int noOfVehicles = (dayVehicleRecords == null || dayVehicleRecords.isEmpty())
                        ? 0 : dayVehicleRecords.size();
                sb.append("    " + noOfVehicles + "          |");
            }
            writeLog(sb.toString());
        }
    }

    protected abstract long getTimeInterval();

}
