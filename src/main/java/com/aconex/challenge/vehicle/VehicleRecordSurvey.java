/**
 *
 */
package com.aconex.challenge.vehicle;

import java.io.File;
import java.io.IOException;

import com.aconex.challenge.vehicle.data.VehicleRecordDataAccess;
import com.aconex.challenge.vehicle.data.exception.InvalidRecordException;
import com.aconex.challenge.vehicle.data.read.VehicleRecordReader;
import com.aconex.challenge.vehicle.reports.count.VehiclesPerHalfHourCountReport;
import com.aconex.challenge.vehicle.reports.count.VehiclesPerHourCountReport;
import com.aconex.challenge.vehicle.reports.count.VehiclesPerQuarterHourCountReport;
import com.aconex.challenge.vehicle.reports.count.VehiclesPerSessionCountReport;
import com.aconex.challenge.vehicle.reports.count.VehiclesPerTwentyMinutesCountReport;
import com.aconex.challenge.vehicle.reports.count.average.AverageVehiclesPerHalfHourCountReport;
import com.aconex.challenge.vehicle.reports.count.average.AverageVehiclesPerHourCountReport;
import com.aconex.challenge.vehicle.reports.distance.average.AverageDistancePerHourReport;
import com.aconex.challenge.vehicle.reports.peak.VehiclesPerHourPeakDataReport;
import com.aconex.challenge.vehicle.reports.speed.average.AverageSpeedPerHourReport;

/**
 * @author bmaturi
 */
public class VehicleRecordSurvey {

    /**
     * @param args
     * @throws IOException
     * @throws InvalidRecordException
     */
    public static void main(String[] args) throws InvalidRecordException, IOException {

        if (args.length < 1) {
            final String message = "Usage : VehicleRecordSurvey <file_path>";
            throw new IllegalArgumentException(message);
        } else {
            final File dataFile = new File(args[0]);
            if (!dataFile.exists()) {
                final String message = "File does not exist. Please provide a valid input data file.";
                throw new IllegalArgumentException(message);
            } else {
                final VehicleRecordDataAccess dataAccess = (VehicleRecordDataAccess) new VehicleRecordReader().read(dataFile);
                System.out.println("#############################################");
                System.out.println("Displaying Reports ::");
                System.out.println("#############################################");

                // vehicle count report
                new VehiclesPerHourCountReport().runReport(dataAccess);
                new VehiclesPerHalfHourCountReport().runReport(dataAccess);
                new VehiclesPerQuarterHourCountReport().runReport(dataAccess);
                new VehiclesPerTwentyMinutesCountReport().runReport(dataAccess);
                new VehiclesPerSessionCountReport().runReport(dataAccess);

                // vehicle count avg report
                new AverageVehiclesPerHourCountReport().runReport(dataAccess);
                new AverageVehiclesPerHalfHourCountReport().runReport(dataAccess);

                // vehicle peak time report
                new VehiclesPerHourPeakDataReport().runReport(dataAccess);

                // Average vehcles speed distribution
                new AverageSpeedPerHourReport().runReport(dataAccess);

                // Average Distance report
                new AverageDistancePerHourReport().runReport(dataAccess);

                System.out.println("#############################################");
                System.out.println("Finished Displaying Reports !!");
                System.out.println("#############################################");
            }
        }

    }

}
