/**
 *
 */
package com.aconex.challenge.vehicle.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccess implements RecordDataAccess {

    private final List<VehicleRecord> vehicleRecords = new ArrayList<VehicleRecord>();

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
