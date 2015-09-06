/**
 *
 */
package com.aconex.challenge.vehicle.reports.count.average;

import org.junit.Test;

import com.aconex.challenge.vehicle.reports.count.InitializeDataAccess;

/**
 * @author bmaturi
 */
public class AverageVehicleCountTest extends InitializeDataAccess {

    @Test
    public void runReportOnHourInterval() {
        new AverageVehiclesPerHourCountReport().runReport(dataAccess);
    }

    @Test
    public void runReportOnHalfHourInterval() {
        new AverageVehiclesPerHalfHourCountReport().runReport(dataAccess);
    }
}
