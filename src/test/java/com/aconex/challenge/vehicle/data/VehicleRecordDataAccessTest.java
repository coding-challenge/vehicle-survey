/**
 *
 */
package com.aconex.challenge.vehicle.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;
import com.aconex.challenge.vehicle.data.read.VehicleRecordReader;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccessTest {

    static VehicleRecordDataAccess dataAccess = null;

    // Whole TestClass fails when file read fails
    @BeforeClass
    public static void setUpTestClass() throws InvalidRecordException, IOException {
        dataAccess = (VehicleRecordDataAccess) new VehicleRecordReader().read(new File(
                VehicleRecordDataAccessTest.class.getResource("/vehicle-data.txt").getFile()));
    }

    @Test
    public void findRecordsInRangeAndDirectionAHourInterval() {
        final Map<Day, List<VehicleRecord>> vehicleRecordsMap = dataAccess.findRecordsInRangeAndDirection(
                0, CONSTANTS.MILLIS.HOUR, Direction.A);
        assertNotNull(vehicleRecordsMap);
        // 5 days records
        assertEquals(5, vehicleRecordsMap.size());
        // 7 vehicles on Monday morning in direction A
        assertEquals(7, vehicleRecordsMap.get(Day.MONDAY).size());
        // 7 vehicles on Friday morning in direction A
        assertEquals(7, vehicleRecordsMap.get(Day.FRIDAY).size());
    }

    @Test
    public void findRecordsInRangeAndDirectionBHourInterval() {
        final Map<Day, List<VehicleRecord>> vehicleRecordsMap = dataAccess.findRecordsInRangeAndDirection(
                0, CONSTANTS.MILLIS.HOUR, Direction.B);
        assertNotNull(vehicleRecordsMap);
        // 5 days records
        assertEquals(5, vehicleRecordsMap.size());
        // 8 vehicles on Monday morning in direction B
        assertEquals(8, vehicleRecordsMap.get(Day.MONDAY).size());
        // 8 vehicles on Friday morning in direction B
        assertEquals(8, vehicleRecordsMap.get(Day.FRIDAY).size());
    }

    @Test
    public void findRecordsInRangeAndDirectionAHalfHourInterval() {
        final Map<Day, List<VehicleRecord>> vehicleRecordsMap = dataAccess.findRecordsInRangeAndDirection(
                0, CONSTANTS.MILLIS.HALF_HOUR, Direction.A);
        assertNotNull(vehicleRecordsMap);
        // 5 days records
        assertEquals(5, vehicleRecordsMap.size());
        // 3 vehicles on Monday morning
        assertEquals(3, vehicleRecordsMap.get(Day.MONDAY).size());
        // 3 vehicles on Friday morning
        assertEquals(3, vehicleRecordsMap.get(Day.FRIDAY).size());
    }

    @Test
    public void findRecordsInRangeAndDirectionA0Interval() {
        final Map<Day, List<VehicleRecord>> vehicleRecordsMap = dataAccess.findRecordsInRangeAndDirection(
                0, 0, Direction.A);
        assertNotNull(vehicleRecordsMap);
        // 5 days records
        assertEquals(5, vehicleRecordsMap.size());
        // 0 vehicles on Monday morning
        assertEquals(0, vehicleRecordsMap.get(Day.MONDAY).size());
        // 0 vehicles on Friday morning
        assertEquals(0, vehicleRecordsMap.get(Day.FRIDAY).size());
    }
}
