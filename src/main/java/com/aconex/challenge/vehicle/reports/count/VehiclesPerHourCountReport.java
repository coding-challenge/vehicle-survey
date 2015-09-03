/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.reports.AbstractVehicleReport;

/**
 * @author bmaturi
 */
public class VehiclesPerHourCountReport extends AbstractVehicleReport {

    @Override
    public void runReport(VehicleRecordDataAccess vehicleDataAccess) {
        final long timeInterval = CONSTANTS.MILLIS.HOUR;

        writeLog(getReportHeader());
        for (final Day day : Day.values()) {
            // report per Day header
            writeHeaderLog(day.name());
            // table header
            writeLog(getTableHeader());

            printReport(timeInterval, vehicleDataAccess, day);

            // table footer
            writeLog("----------------------------------------------------");
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

    private void writeHeaderLog(String message) {
        System.out.println("************************************************");
        System.out.println(message);
        System.out.println("************************************************");
    }

    private String getHoursFromTimestamp(long timestamp) {
        final SimpleDateFormat sdf = new SimpleDateFormat(CONSTANTS.DATE_PATTERN.HOUR_PATTERN);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return sdf.format(new Date(calendar.getTime().getTime() + timestamp));

    }

    private String getTableHeader() {
        final StringBuffer sb = new StringBuffer("|__HOUR__|");
        for (final Direction direction : Direction.values()) {
            sb.append("__" + direction + "__|");
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return "HOUR";
    }

    @Override
    public String getReportHeader() {
        return "Report : " + getName();
    }

    @Override
    public String getReportFooter() {
        return "Finished generating " + getName() + " report.";
    }

}
