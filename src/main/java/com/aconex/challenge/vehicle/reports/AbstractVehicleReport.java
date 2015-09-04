/**
 *
 */
package com.aconex.challenge.vehicle.reports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public abstract class AbstractVehicleReport implements VehicleReport {

    // using System.out , Can be changed to use any logger
    // when required
    protected void writeLog(String log) {
        System.out.println(log);
    }

    protected void writeHeaderLog(String message) {
        System.out.println("************************************************");
        System.out.println(message);
        System.out.println("************************************************");
    }

    @Override
    public String getReportHeader() {
        return "Report : " + getName();
    }

    @Override
    public String getReportFooter() {
        return "Finished generating " + getName() + " report.";
    }

    protected String getHoursFromTimestamp(long timestamp) {
        final SimpleDateFormat sdf = new SimpleDateFormat(CONSTANTS.DATE_PATTERN.HOUR_PATTERN);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return sdf.format(new Date(calendar.getTime().getTime() + timestamp));

    }

    /**
     * Returns the list of days
     *
     * @return List<Day>
     */
    protected List<Day> getDays() {
        final List<Day> days = new ArrayList<Day>();

        for (final Day day : Day.values()) {
            days.add(day);
        }
        return days;
    }

    /**
     * Returns list of directions
     *
     * @return List<Direction>
     */
    protected List<Direction> getDirections() {
        final List<Direction> directions = new ArrayList<Direction>();
        for (final Direction direction : Direction.values()) {
            directions.add(direction);
        }
        return directions;
    }

}
