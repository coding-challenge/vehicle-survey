/**
 *
 */
package com.aconex.challenge.vehicle.data;

import java.util.List;

import com.aconex.challenge.vehicle.VehicleRecord;

/**
 * Interface to be implemented to provide functionalities to add , get data and implement other
 * custom data retrieval methods
 * 
 * @author bmaturi
 */
public interface RecordDataAccess {

    public void add(VehicleRecord vehicleRecord);

    public void add(List<VehicleRecord> vehicleRecords);

    public List<VehicleRecord> getAllRecords();

}
