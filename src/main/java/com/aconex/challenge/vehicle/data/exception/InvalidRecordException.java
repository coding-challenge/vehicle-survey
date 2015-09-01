/**
 *
 */
package com.aconex.challenge.vehicle.data.exception;

/**
 * This exception is thrown from the Reader when an invalid input record is encountered
 * 
 * @author bmaturi
 */
@SuppressWarnings(value = {
    "serial"
})
public class InvalidRecordException extends RuntimeException {

    private static final String INVALID_RECORD = "INVALID RECORD";

    private final long lineNUmber;

    private final String data;

    public InvalidRecordException(long lineNumber, String data) {
        super(INVALID_RECORD);
        this.lineNUmber = lineNumber;
        this.data = data;
    }

    /**
     * @return the lineNUmber
     */
    public long getLineNUmber() {
        return lineNUmber;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

}
