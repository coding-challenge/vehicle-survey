/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import org.junit.Test;

/**
 * All the tests are not validated for their output but are expected to not throw any exception.
 *
 * @author bmaturi
 */
public class VehicleCountTest extends InitializeDataAccess {

    @Test
    public void runReportOnHourInterval() {
        new VehiclesPerHourCountReport().runReport(dataAccess);
    }

    @Test
    public void runReportOnHalfHourInterval() {
        new VehiclesPerHalfHourCountReport().runReport(dataAccess);
    }

    @Test
    public void runReportOnQuarterHourInterval() {
        new VehiclesPerQuarterHourCountReport().runReport(dataAccess);
    }

    @Test
    public void runReportOnSessionInterval() {
        new VehiclesPerSessionCountReport().runReport(dataAccess);
    }

    @Test
    public void runReportOnTwentyMonutesInterval() {
        new VehiclesPerTwentyMinutesCountReport().runReport(dataAccess);
    }

}
