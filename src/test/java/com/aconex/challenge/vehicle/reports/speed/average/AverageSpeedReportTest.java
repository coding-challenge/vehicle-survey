/**
 *
 */
package com.aconex.challenge.vehicle.reports.speed.average;

import org.junit.Test;

import com.aconex.challenge.vehicle.reports.count.InitializeDataAccess;

/**
 * @author bmaturi
 */
public class AverageSpeedReportTest extends InitializeDataAccess {

    @Test
    public void runReportPerHour() {
        new AverageSpeedPerHourReport().runReport(dataAccess);
    }
}
