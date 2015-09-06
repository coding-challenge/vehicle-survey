/**
 *
 */
package com.aconex.challenge.vehicle.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;
import com.aconex.challenge.vehicle.reports.count.InitializeDataAccess;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccessTest extends InitializeDataAccess {

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

    @Test
    public void fetchAverageDistancesBetweenvehiclesPerHourDirA() {
        final Map<Long, String> averageDistanceMap = dataAccess.fetchAverageDistancesBetweenvehicles(
                CONSTANTS.MILLIS.HOUR, Direction.A);
        assertNotNull(averageDistanceMap);
        assertEquals(24, averageDistanceMap.size());
    }

    @Test
    public void fetchAverageDistancesBetweenvehiclesPerHourDirB() {
        final Map<Long, String> averageDistanceMap = dataAccess.fetchAverageDistancesBetweenvehicles(
                CONSTANTS.MILLIS.HOUR, Direction.B);
        assertNotNull(averageDistanceMap);
        assertEquals(24, averageDistanceMap.size());
    }

}
