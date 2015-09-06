/**
 *
 */
package com.aconex.challenge.vehicle.reports.distance.average;

import org.junit.Test;

import com.aconex.challenge.vehicle.reports.count.InitializeDataAccess;

/**
 * @author bmaturi
 */
public class AverageDistanceReportTest extends InitializeDataAccess {

    @Test
    public void runReportPerHour() {
        new AverageDistancePerHourReport().runReport(dataAccess);
    }
}
