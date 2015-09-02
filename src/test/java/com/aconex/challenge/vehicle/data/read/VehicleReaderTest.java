/**
 *
 */
package com.aconex.challenge.vehicle.data.read;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.data.RecordDataAccess;
import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;

/**
 * @author bmaturi
 */
public class VehicleReaderTest {

    // The read method is not expected to throw any exception
    @Test
    public void read() throws InvalidRecordException, IOException {
        final RecordDataAccess dataAccess = new VehicleRecordReader().read(new File(getClass().getResource(
                "/vehicle-data.txt").getFile()));
        assertNotNull(dataAccess);
        assertEquals("Should contain 330 vehicle records", 330, dataAccess.getAllRecords().size());
        assertEquals("First record should be on MONDAY", Day.MONDAY, dataAccess.getAllRecords().get(0).getDay());
        // last record should be on a Friday since we have 5 days of records starting with Monday
        assertEquals(
                "Last record should be on FRIDAY", Day.FRIDAY,
                dataAccess.getAllRecords().get(dataAccess.getAllRecords().size() - 1).getDay());
    }

    @Test(expected = FileNotFoundException.class)
    public void readOnNoFile() throws InvalidRecordException, IOException {
        new VehicleRecordReader().read(null);
    }

    @Test(expected = InvalidRecordException.class)
    public void readOnInvalidData() throws InvalidRecordException, IOException {
        new VehicleRecordReader().read(new File(getClass().getResource("/vehicle-data-bad.txt").getFile()));
    }
}
