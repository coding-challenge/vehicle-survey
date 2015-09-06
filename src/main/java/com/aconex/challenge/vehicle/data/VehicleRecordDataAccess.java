/**
 *
 */
package com.aconex.challenge.vehicle.data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.constants.CONSTANTS;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccess implements RecordDataAccess {

    private final List<VehicleRecord> vehicleRecords = new ArrayList<VehicleRecord>();

    // Speed in kmph
    private static final float VEHICLE_AVERAGE_SPEED = 60;

    /**
     * This method returns a Map of all the days in the vehicle records and the corresponding
     * vehicle records for the input direction and the time interval
     *
     * @param startTime
     * @param endTime
     * @param direction
     * @return Map<Day, List<VehicleRecord>>
     */
    public Map<Day, List<VehicleRecord>> findRecordsInRangeAndDirection(long startTime,
                                                                        long endTime,
                                                                        Direction direction) {

        final Map<Day, List<VehicleRecord>> resultMap = new TreeMap<Day, List<VehicleRecord>>();

        for (final VehicleRecord record : vehicleRecords) {
            final long timestamp = record.getRecords().get(0).getTimestamp();
            if (isDirectionMatch(direction, record)) {
                List<VehicleRecord> vRecords = resultMap.get(record.getDay());
                if (vRecords == null) {
                    vRecords = new ArrayList<VehicleRecord>();
                }
                if (timestamp > startTime && timestamp < endTime) {
                    vRecords.add(record);
                }
                resultMap.put(record.getDay(), vRecords);
            }
        }
        return resultMap;
    }

    /**
     * This method returns a map of timeinterval to Average distance in metres b/w vehicles for all
     * the days the records are available for.
     *
     * @param timeInterval
     * @param direction
     * @return Map<Long, String>
     */
    public Map<Long, String> fetchAverageDistancesBetweenvehicles(long timeInterval, Direction direction) {
        final Map<Long, String> averageResultMap = new HashMap<Long, String>();
        for (long initialTime = 0; initialTime < CONSTANTS.MILLIS.DAY; initialTime += timeInterval) {
            final Map<Day, List<VehicleRecord>> vehicleRecordsMap = findRecordsInRangeAndDirection(
                    initialTime, initialTime + timeInterval, direction);

            long totalDistanceinMetres = 0;
            int noOfCOunts = 0;
            for (final List<VehicleRecord> records : vehicleRecordsMap.values()) {
                if (records == null || records.isEmpty()) {
                    continue;
                } else {
                    VehicleRecord prevVehicleRecord = null;
                    for (final VehicleRecord vehicleRecord : records) {
                        final long timeBetweenVehicles = getTimeBetweenvehicles(prevVehicleRecord, vehicleRecord);

                        totalDistanceinMetres += (VEHICLE_AVERAGE_SPEED * 1000 * timeBetweenVehicles)
                                / CONSTANTS.MILLIS.HOUR;
                        prevVehicleRecord = vehicleRecord;
                        noOfCOunts++;
                    }
                }
            }
            if (totalDistanceinMetres == 0) {
                averageResultMap.put(Long.valueOf(initialTime), "0");
            } else {
                final DecimalFormat decimalFormat = new DecimalFormat("0.000");
                averageResultMap.put(
                        Long.valueOf(initialTime), decimalFormat.format(totalDistanceinMetres / noOfCOunts));
            }
        }
        return averageResultMap;
    }

    @Override
    public void add(VehicleRecord vehicleRecord) {
        this.vehicleRecords.add(vehicleRecord);
    }

    @Override
    public void add(List<VehicleRecord> vehicleRecords) {
        this.vehicleRecords.addAll(vehicleRecords);
    }

    @Override
    public List<VehicleRecord> getAllRecords() {
        return this.vehicleRecords;
    }

    private long getTimeBetweenvehicles(VehicleRecord prevVehicleRecord, VehicleRecord vehicleRecord) {
        long time = 0;
        if (prevVehicleRecord != null) {
            time = vehicleRecord.getRecords().get(0).getTimestamp()
                    - prevVehicleRecord.getRecords().get(0).getTimestamp();
        }
        return time;
    }

    private boolean isDirectionMatch(Direction direction, VehicleRecord record) {
        boolean match = false;

        switch (direction) {
            case A:
                if (record.getRecords().size() == 2) {
                    match = true;
                }
                break;
            case B:
                if (record.getRecords().size() == 4) {
                    match = true;
                }
                break;
        }

        return match;
    }

}
