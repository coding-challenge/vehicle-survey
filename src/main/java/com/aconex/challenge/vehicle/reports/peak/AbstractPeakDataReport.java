/**
 *
 */
package com.aconex.challenge.vehicle.reports.peak;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.data.PeakData;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.reports.AbstractVehicleReport;

/**
 * @author bmaturi
 */
public abstract class AbstractPeakDataReport extends AbstractVehicleReport {

    @Override
    public void runReport(VehicleRecordDataAccess vehicleDataAccess) {

        writeLog(getReportHeader());
        // table header
        writeLog(getTableHeader());

        for (final Day day : getDays()) {
            printReport(getTimeInterval(), vehicleDataAccess, day);
        }
        // table footer
        writeLog(getTableFooter());
        writeLog(getReportFooter());
    }

    private void printReport(long timeInterval, VehicleRecordDataAccess vehicleDataAccess, Day day) {

        for (final Direction direction : getDirections()) {
            final StringBuffer sb = new StringBuffer("| " + day + "   | ");
            final PeakData peakData = vehicleDataAccess.getPeakDataForDirection(timeInterval, direction, day);
            sb.append(direction + " |  ");
            sb.append(getHoursFromTimestamp(peakData.getTimestamp()) + " | ").append(peakData.getNoOfVehicles() + " |");
            writeLog(sb.toString());
        }
    }

    private String getTableHeader() {
        final StringBuffer sb = new StringBuffer("|__DAY_____|");
        sb.append("__DIRECTION___|");
        sb.append("___" + getTimeIntervalName() + "__|");
        sb.append("__No Of vehicles__|");
        return sb.toString();
    }

    private String getTableFooter() {
        return "----------------------------------------------------";
    }

    protected abstract long getTimeInterval();

    protected abstract String getTimeIntervalName();

}
