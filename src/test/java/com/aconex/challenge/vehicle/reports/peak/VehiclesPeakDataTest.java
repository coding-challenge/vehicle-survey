/**
 *
 */
package com.aconex.challenge.vehicle.reports.peak;

import org.junit.Test;

import com.aconex.challenge.vehicle.reports.count.InitializeDataAccess;

/**
 * @author bmatueri
 */
public class VehiclesPeakDataTest extends InitializeDataAccess {

    @Test
    public void runReportPerHour() {
        new VehiclesPerHourPeakDataReport().runReport(dataAccess);
    }
}
