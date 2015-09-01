/**
 *
 */
package com.aconex.challenge.vehicle.data;

import java.util.ArrayList;
import java.util.List;

import com.aconex.challenge.vehicle.VehicleRecord;

/**
 * @author bmaturi
 */
public class VehicleRecordDataAccess implements RecordDataAccess {

    private final List<VehicleRecord> vehicleRecords = new ArrayList<VehicleRecord>();

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
