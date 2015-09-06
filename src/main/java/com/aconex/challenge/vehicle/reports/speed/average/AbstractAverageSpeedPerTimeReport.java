/**
 *
 */
package com.aconex.challenge.vehicle.reports.speed.average;

import java.util.Map;

import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.reports.AbstractVehicleReport;

/**
 * @author bmaturi
 */
public abstract class AbstractAverageSpeedPerTimeReport extends AbstractVehicleReport {

    @Override
    public void runReport(VehicleRecordDataAccess vehicleDataAccess) {
        writeLog(getReportHeader());
        // report per Day header
        writeHeaderLog("Average of ALL days");

        printReport(getTimeInterval(), vehicleDataAccess);

        // table footer
        writeLog(getTableFooter());
        writeLog(getReportFooter());

    }

    private void printReport(long timeInterval, VehicleRecordDataAccess vehicleDataAccess) {
        for (final Direction direction : getDirections()) {
            // table header
            writeLog(getTableHeader(direction));
            final Map<Long, String> averageResult = vehicleDataAccess.fetchAverageSpeedForTimeInterval(
                    getTimeInterval(), direction);
            for (final Map.Entry<Long, String> entry : averageResult.entrySet()) {
                writeLog("|  " + getHoursFromTimestamp(entry.getKey()) + " |   " + entry.getValue() + "      |");
            }
            writeLog(getTableFooter());
        }

    }

    private String getTableFooter() {
        return "----------------------------------------------------";
    }

    private String getTableHeader(Direction direction) {
        final StringBuffer sb = new StringBuffer("|__" + getTimeIntervalName() + "__|");
        sb.append("__" + direction + "__|");
        return sb.toString();
    }

    protected abstract long getTimeInterval();

    protected abstract String getTimeIntervalName();

}
