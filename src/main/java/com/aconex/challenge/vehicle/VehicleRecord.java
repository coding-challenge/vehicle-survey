/**
 * 
 */
package com.aconex.challenge.vehicle;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds the information about all the records generated 
 * by the vehicle while passing through the rubber hose once.
 * 
 * @author bmaturi
 *
 */
public class VehicleRecord {
    
    private List<Record> records;

    
    /**
     * @return the records
     */
    public List<Record> getRecords() {
        return records;
    }

    
    /**
     * @param records the records to set
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }
    
    /**
     * Adds the record to the records list; initializes the 
     * list if null
     * @param record
     */
    public void addRecord(Record record) {
        if (this.records == null) {
            this.records = new ArrayList<Record>();
        } 
        this.records.add(record);
    }

}
