/**
 *
 */
package com.aconex.challenge.vehicle.reports.count;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccessTest;
import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;
import com.aconex.challenge.vehicle.data.read.VehicleRecordReader;

/**
 * All the tests are not validated for their output but are expected to not throw any exception.
 *
 * @author bmaturi
 */
public class VehicleCountTest {

    static VehicleRecordDataAccess dataAccess = null;

    // Whole TestClass fails when file read fails
    @BeforeClass
    public static void setUpTestClass() throws InvalidRecordException, IOException {
        dataAccess = (VehicleRecordDataAccess) new VehicleRecordReader().read(new File(
                VehicleRecordDataAccessTest.class.getResource("/vehicle-data.txt").getFile()));
    }

    @Test
    public void runReportOnHourInterval() {
        new VehiclesPerHourCountReport().runReport(dataAccess);
    }

}
