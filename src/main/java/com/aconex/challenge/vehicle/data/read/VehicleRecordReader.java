/**
 *
 */
package com.aconex.challenge.vehicle.data.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aconex.challenge.vehicle.Day;
import com.aconex.challenge.vehicle.Direction;
import com.aconex.challenge.vehicle.Record;
import com.aconex.challenge.vehicle.VehicleRecord;
import com.aconex.challenge.vehicle.data.RecordDataAccess;
import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;

/**
 * @author bmaturi
 */
public class VehicleRecordReader implements RecordReader {

    private final Pattern pattern = Pattern.compile("([abAB])(\\d+)");

    @Override
    public RecordDataAccess read(File file) throws IOException, InvalidRecordException {
        validateFile(file);

        final RecordDataAccess dataAccess = new VehicleRecordDataAccess();

        // Read the file using BufferedReader,FileReader
        // to handle large files also
        try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader);) {

            int day = 1;

            // keeping track of the last record
            VehicleRecord vehicleRecord = null;
            Record lastRecord = null;
            long lineNo = 0;

            String line = "";
            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isEmpty()) {
                    continue;
                }

                final Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {

                    Day dayEnum = Day.fromValue(day);

                    // extracting two groups from the input line
                    final long timestamp = Long.parseLong(matcher.group(2));
                    final String direction = matcher.group(1);

                    final Record record = new Record(Direction.fromValue(direction), timestamp);

                    if (vehicleRecord == null || vehicleRecord.getRecords().size() == 4) {
                        if (lastRecord != null && lastRecord.getTimestamp() > timestamp) {
                            day++;
                            if (day > 7) {
                                day = 1;
                            }
                            dayEnum = Day.fromValue(day);
                        }
                        vehicleRecord = new VehicleRecord(dayEnum);
                        vehicleRecord.addRecord(record);
                        lastRecord = record;
                    } else {

                        if (lastRecord.getDirection() == Direction.A && record.getDirection() == Direction.A) {
                            vehicleRecord.addRecord(record);
                            vehicleRecord = null;
                            lastRecord = record;
                            continue;
                        } else if ((lastRecord.getDirection() == Direction.A && record.getDirection() == Direction.B)
                                || (lastRecord.getDirection() == Direction.B && record.getDirection() == Direction.A)) {
                            vehicleRecord.addRecord(record);
                            lastRecord = record;
                            continue;
                        } else {
                            throw new InvalidRecordException(lineNo, line);
                        }
                    }

                    dataAccess.add(vehicleRecord);
                } else {
                    throw new InvalidRecordException(lineNo, line);
                }
            }
        } catch (final IOException e) {
            throw e;
        }

        return dataAccess;
    }

    private void validateFile(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }

    }

}
