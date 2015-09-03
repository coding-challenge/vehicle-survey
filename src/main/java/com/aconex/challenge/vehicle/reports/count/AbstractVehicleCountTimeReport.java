/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.reports.AbstractVehicleReport;

/**
 * @author bmaturi
 */
public abstract class AbstractVehicleCountTimeReport extends AbstractVehicleReport {

    protected String getTableHeader() {
        final StringBuffer sb = new StringBuffer("|__" + getTimeIntervalName() + "__|");
        for (final Direction direction : getDirections()) {
            sb.append("__" + direction + "__|");
        }
        return sb.toString();
    }

    protected String getTableFooter() {
        return "----------------------------------------------------";
    }

    protected abstract String getTimeIntervalName();
}
