/**
 *
 */
package com.aconex.challenge.vehicle.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.VehicleRecord;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccess implements RecordDataAccess {

    private final List<VehicleRecord> vehicleRecords = new ArrayList<VehicleRecord>();

    public Map<Day, List<VehicleRecord>> findRecordsInRangeAndDirection(long startTime,
                                                                        long endTime,
                                                                        Direction direction) {
        
        return null;
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

}
