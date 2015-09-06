/**
 *
 */
package com.aconex.challenge.vehicle.reports.count.average;

import java.util.List;
import java.util.Map;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.reports.count.AbstractVehicleCountTimeReport;

/**
 * @author bmaturi
 */
public abstract class AbstractAverageVehicleCountTimeReport extends AbstractVehicleCountTimeReport {

    @Override
    public void runReport(VehicleRecordDataAccess vehicleDataAccess) {
        final long timeInterval = getTimeInterval();

        writeLog(getReportHeader());
        // report per Day header
        writeHeaderLog("Average of ALL days");
        // table header
        writeLog(getTableHeader());

        printReport(timeInterval, vehicleDataAccess);

        // table footer
        writeLog(getTableFooter());
        writeLog(getReportFooter());

    }

    private void printReport(long timeInterval, VehicleRecordDataAccess vehicleDataAccess) {
        for (long startTime = 0; startTime < CONSTANTS.MILLIS.DAY; startTime += timeInterval) {

            final StringBuffer sb = new StringBuffer("|  " + getHoursFromTimestamp(startTime) + " |");
            for (final Direction direction : Direction.values()) {
                final Map<Day, List<VehicleRecord>> vehicleRecords = vehicleDataAccess.findRecordsInRangeAndDirection(
                        startTime, startTime + timeInterval, direction);
                final float noOfVehicles = getAverageNofVehicleRecords(vehicleRecords);
                sb.append("    " + noOfVehicles + "          |");
            }
            writeLog(sb.toString());
        }
    }

    private float getAverageNofVehicleRecords(Map<Day, List<VehicleRecord>> vehicleRecords) {
        float avgNumberOfVehicles = 0;

        if (vehicleRecords != null && !vehicleRecords.isEmpty()) {
            int totalCount = 0;
            for (final Day day : getDays()) {
                final List<VehicleRecord> dayVehicleRecords = vehicleRecords.get(day);
                final int count = (dayVehicleRecords == null) ? 0 : dayVehicleRecords.size();
                totalCount += count;
            }
            if (totalCount != 0) {
                avgNumberOfVehicles = totalCount / getDays().size();
            }
        }

        return avgNumberOfVehicles;
    }

    protected abstract long getTimeInterval();

    @Override
    protected abstract String getTimeIntervalName();

}
