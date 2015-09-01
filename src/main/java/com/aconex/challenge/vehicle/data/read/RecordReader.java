/**
 *
 */
package com.aconex.challenge.vehicle.data.read;

import java.io.File;
import java.io.IOException;

import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;

/**
 * @author bmaturi
 */
public interface RecordReader {

    public RecordReader read(File file) throws IOException, InvalidRecordException;

}
