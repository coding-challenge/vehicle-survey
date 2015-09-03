/**
 *
 */
package com.aconex.challenge.vehicle.reports;

import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;

/**
 * Interface defining basic methods required to generate a report. All Reporting classes should
 * implement this interface
 *
 * @author bmaturi
 */
public interface VehicleReport {

    /**
     * Generates the report data.
     *
     * @param vehicleDataAccess
     */
    public void runReport(VehicleRecordDataAccess vehicleDataAccess);

    /**
     * Name of the report
     *
     * @return String
     */
    public String getName();

    /**
     * Header for the report
     *
     * @return String
     */
    public String getReportHeader();

    /**
     * Footer for the report
     *
     * @return String
     */
    public String getReportFooter();

}
